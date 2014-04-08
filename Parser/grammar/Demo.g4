grammar Demo;

program: (println ';')+;

expression: left=expression '+' right=NUMBER #Plus
          | left=expression '-' right=NUMBER #Minus
          | number=NUMBER #Number
          ;

println: 'println(' argument=expression ')' ;

NUMBER: [0-9]+;
WHITESPACE: [ \t\n\r]+ -> skip;