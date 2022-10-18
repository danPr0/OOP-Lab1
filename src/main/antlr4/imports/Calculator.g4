grammar Calculator;

program: assign;
assign: VARIABLE ' = ' expression;
//print: expression;
//parents: '(' expression ')';
//expression: expression (ADD|MINUS|MUL|DIV|MOD) expression | VARIABLE | OPRAND | parents;
expression:'(' expression ')'               # Parents
          | expression ADD expression       # ADD
          | expression MINUS expression     # MINUS
          | expression MUL expression       # MUL
          | expression DIV expression       # DIV
          | expression INT_DIV expression   # INT_DIV
          | expression MOD expression       # MOD
          | expression POW expression       # POW
          | INC expression                  # INC
          | DEC expression                  # DEC
          | VARIABLE                        # Variable
          | CYCLE                           # Cycle
          | OPERAND                         # Operand
          | PI_CONSTANT                     # PI
          | EXP_CONSTANT                    # E
          ;

VARIABLE: [A-Z]+[0-9]+;
CYCLE: '???';
OPERAND: INT | DOUBLE;
INT: [0-9]+('_'[0-9]+)*;
DOUBLE: [0-9]+('_'[0-9]+)* '.' [0-9]+('_'[0-9]+)*;
ADD: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
INT_DIV: 'div'|'DIV';
MOD: 'mod'|'MOD';
POW: '^';
INC: 'inc'|'INC';
DEC: 'dec'|'DEC';
PI_CONSTANT: 'PI'|'pi';
EXP_CONSTANT: 'E'|'e';

NEWLINE: [\t\r\n] -> skip;
WS: ' ' -> skip;