grammar Demo;

program: programPart+ ;

programPart: statement           #MainStatement
           | functionDefinition  #ProgPartFunctionDefinition
           ;

statement: println ';'
         | print ';'
         | varDeclaration ';'
         | assignment ';'
         | branch
         ;

branch: 'if' '(' condition=expression ')' onTrue=block 'else' onFalse=block
      ;

block: '{' statement* '}' ;

expression: '(' left=expression ')'               #Composite
          | left=expression '/' right=expression  #Div
          | left=expression '*' right=expression  #Mult
          | left=expression '-' right=expression  #Minus
          | left=expression '+' right=expression  #Plus
          | left=expression operator=('<' | '<=' | '>' | '>=') right=expression #Relational
          | left=expression '&&' right=expression #And
          | left=expression '||' right=expression #Or
          | number=NUMBER                         #Number
          | txt=STRING                            #String
          | varName=IDENTIFIER                    #Variable
          | functionCall                          #funcCallExpression
          ;

varDeclaration: 'int' varName=IDENTIFIER ;

assignment: varName=IDENTIFIER '=' expr=expression ;

println: 'println' + '(' argument=expression ')' ;

print: 'print' +'(' argument=expression ')' ;

functionDefinition: 'int' funcName=IDENTIFIER '(' params=parameterDeclaration ')' '{' statements=statementList 'return' returnValue=expression ';' '}' ;

parameterDeclaration: declarations+=varDeclaration (',' declarations+=varDeclaration)*
                    |
                    ;

statementList: statement* ;

functionCall: funcName=IDENTIFIER '(' arguments=expressionList ')' ;

expressionList: expressions+=expression (',' expressions+=expression)*
              |
              ;

BlockComment: '/*' .*? '*/' -> skip ;

LineComment: '//' ~[\r\n]* -> skip ;

IDENTIFIER: [a-zA-Z][a-zA-Z0-9]* ;

NUMBER: [0-9]+ ;

WHITESPACE: [ \t\n\r]+ -> skip ;

STRING: '"' .*? '"' ;
