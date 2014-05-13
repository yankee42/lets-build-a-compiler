grammar Demo;

program: programPart+ ;

programPart: statement           #MainStatement
           | functionDefinition  #ProgPartFunctionDefinition
           ;

statement: println ';'
         | varDeclaration ';'
         | assignment ';'
         | branch
         ;

branch: 'if' '(' condition=expression ')' onTrue=block 'else' onFalse=block
      ;

block: '{' statement* '}' ;

expression: left=expression '/' right=expression #Div
          | left=expression '*' right=expression #Mult
          | left=expression '-' right=expression #Minus
          | left=expression '+' right=expression #Plus
          | number=NUMBER #Number
          | varName=IDENTIFIER #Variable
          | functionCall #funcCallExpression
          ;

varDeclaration: 'int' varName=IDENTIFIER ;

assignment: varName=IDENTIFIER '=' expr=expression;

println: 'println(' argument=expression ')' ;

functionDefinition: 'int' funcName=IDENTIFIER '(' params=parameterDeclaration ')' '{' statements=statementList 'return' returnValue=expression ';' '}' ;

parameterDeclaration: declarations+=varDeclaration (',' declarations+=varDeclaration)*
                    |
                    ;

statementList: statement* ;

functionCall: funcName=IDENTIFIER '(' arguments=expressionList ')' ;

expressionList: expressions+=expression (',' expressions+=expression)*
              |
              ;

IDENTIFIER: [a-zA-Z][a-zA-Z0-9]* ;
NUMBER: [0-9]+;
WHITESPACE: [ \t\n\r]+ -> skip;