grammar Demo;

program: (println ';')+;

expression: left=expression '/' right=expression #Div
          | left=expression '*' right=expression #Mult
          | left=expression '-' right=expression #Minus
          | left=expression '+' right=expression #Plus
          | number=NUMBER #Number
          ;

println: 'println(' argument=expression ')' ;

NUMBER: [0-9]+;
WHITESPACE: [ \t\n\r]+ -> skip;