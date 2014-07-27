grammar Demo;

program: programPart+ ;

programPart:
    statement           #MainStatement
  | functionDefinition  #ProgPartFunctionDefinition
  ;

statement:
    println ';'
  | print ';'
  | varDeclaration ';'
  | assignment ';'
  | branch
  ;

branch:
    'if' '(' condition=expression ')' onTrue=block
    'else' onFalse=block ;

block:
    '{' statement* '}' ;

expression:
    '(' left=expression ')'                #Composite
  | left=expression '/' right=expression   #Div
  | left=expression '*' right=expression   #Mult
  | left=expression '-' right=expression   #Minus
  | left=expression '+' right=expression   #Plus
  | left=expression operator=('<' | '<=' | '>' | '>=') right=expression #Relational
  | left=expression '&&' right=expression  #And
  | left=expression '||' right=expression  #Or
  | integer=INTEGER                        #Int
  | longInteger=LONG_INTEGER               #Long
  | floatNumber=FLOAT_NUMBER               #Float
  | doubleNumber=DOUBLE_NUMBER             #Double
  | txt=STRING                             #String
  | varName=IDENTIFIER                     #Variable
  | functionCall                           #funcCallExpression
  ;

typeScalar:
  //'bool' | 'byte' | 'char' | 'short' |
    'int' | 'long' | 'float' | 'double' | 'string' ;

varDeclaration:
    type=typeScalar varName=IDENTIFIER ;

assignment:
    varName=IDENTIFIER '=' expr=expression ;

println:
    'println' + '(' argument=expression ')' ;

print:
    'print' +'(' argument=expression ')' ;

functionDefinition:
    returnType=typeScalar
    funcName=IDENTIFIER '(' params=parameterDeclaration ')' '{'
        statements=statementList
        'return' returnValue=expression ';'
    '}' ;

parameterDeclaration:
    declarations+=varDeclaration (',' declarations+=varDeclaration)*
  |
  ;

statementList:
    statement* ;

functionCall:
    funcName=IDENTIFIER '(' arguments=expressionList ')' ;

expressionList:
    expressions+=expression (',' expressions+=expression)*
  |
  ;

BLOCK_COMMENT  : '/*' .*? '*/' -> skip ;

LINE_COMMENT   : '//' ~[\r\n]* -> skip ;

IDENTIFIER     : [a-zA-Z][a-zA-Z0-9]* ;

INTEGER        : '-'? [0-9]+ ;
LONG_INTEGER   : INTEGER 'L' ;
FLOAT_NUMBER   : INTEGER ('.' INTEGER)? 'F' ;
DOUBLE_NUMBER  : INTEGER ('.' INTEGER)? 'D' ;

NUMBER         : INTEGER | LONG_INTEGER | FLOAT_NUMBER | DOUBLE_NUMBER ;

WHITESPACE     : [ \t\n\r]+ -> skip ;

STRING         : '"' .*? '"' ;
