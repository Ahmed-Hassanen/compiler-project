grammar JavaCode;


compilationUnit : (string|codeBlock)+;
string:Any+;
codeBlock :  '{' string  ;
Any : . ;

parseJavaCode : compilationUnit ;
