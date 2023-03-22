grammar JavaCode;

// Parser rules

compilationUnit : (string|codeBlock)+;
string:Any+;
codeBlock :  '{' ( string | ~( '{' | '}' ))* '}'? ;
// Lexer rules
Whitespace : [\t\r]+ -> skip ;
Invalid : ~[a-zA-Z_0-9{}\n\r\t ] ;
Any : . ;

// Entry point
parseJavaCode : compilationUnit ;
