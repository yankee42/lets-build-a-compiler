grammar Demo;

program: programPart+ ;

programPart: statement ';'       #MainStatement
           | functionDefinition  #ProgPartFunctionDefinition
           ;

statement: println
         | varDeclaration
         | assignment
         ;

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

functionDefinition: 'int' funcName=IDENTIFIER '(' ')' '{' statements=statementList 'return' returnValue=expression ';' '}' ;

statementList: (statement ';')* ;

functionCall: funcName=IDENTIFIER '(' ')' ; 

IDENTIFIER: [a-zA-Z][a-zA-Z0-9]* ;
NUMBER: [0-9]+;
WHITESPACE: [ \t\n\r]+ -> skip;