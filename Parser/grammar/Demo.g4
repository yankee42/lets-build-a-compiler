grammar Demo;

addition: addition '+' ZAHL
        | ZAHL
        ;

ZAHL: [0-9]+;