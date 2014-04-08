grammar Demo;

addition: links=addition '+' rechts=ZAHL #Plus
        | zahl=ZAHL #Zahl
        ;

ZAHL: [0-9]+;