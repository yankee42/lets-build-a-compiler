grammar Demo;

program: (println ';')+;

addition: links=addition '+' rechts=ZAHL #Plus
        | zahl=ZAHL #Zahl
        ;

println: 'println(' argument=addition ')' ;

ZAHL: [0-9]+;