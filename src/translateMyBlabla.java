public class translateMyBlabla{
    public static void main(String[] args) {
        String test = "akuo gk hartk akuo rc ktuvch ,ur,l uthi kbu nfauk";
        String test2 = "אםוביק פשד ש צםמ פםדאק";
        System.out.println(translateEnHe(test));
        System.out.println(translateHeEn(test2));
    }

public static String translateEnHe(String blabla){
    String ans = "";
    for (int i = 0; i < blabla.length(); i++) {
        switch (blabla.charAt(i)) {
            case 'q':
                ans+="/";
                break;
            case 'w':
                ans+="'";
                break;
            case 'e':
                ans+="ק";
                break;
            case 'r':
                ans+="ר";
                break;
            case 't':
                ans+="א";
                break;
            case 'y':
                ans+="ט";
                break;
            case 'u':
                ans+="ו";
                break;
            case 'i':
                ans+="ן";
                break;
            case 'o':
                ans+="ם";
                break;
            case 'p':
                ans+="פ";
                break;
            case '[':
                ans+="]";
                break;
            case ']':
                ans+="[";
                break;
            case '{':
                ans+="}";
                break;
            case '}':
                ans+="{";
                break;
            case 'a':
                ans+="ש";
                break;
            case 's':
                ans+="ד";
                break;
            case 'd':
                ans+="ג";
                break;
            case 'f':
                ans+="כ";
                break;
            case 'g':
                ans+="ע";
                break;
            case 'h':
                ans+="י";
                break;
            case 'j':
                ans+="ח";
                break;
            case 'k':
                ans+="ל";
                break;
            case 'l':
                ans+="ך";
                break;
            case ';':
                ans+="ף";
                break;
            case 'z':
                ans+="ז";
                break;
            case 'x':
                ans+="ס";
                break;
            case 'c':
                ans+="ב";
                break;
            case 'v':
                ans+="ה";
                break;
            case 'b':
                ans+="נ";
                break;
            case 'n':
                ans+="מ";
                break;
            case 'm':
                ans+="צ";
                break;
            case ',':
                ans+="ת";
                break;
            case '<':
                ans+=">";
                break;
            case '.':
                ans+="ץ";
                break;
            case '>':
                ans+="<";
                break;
            case '/':
                ans+=".";
                break;
            
                default:
                ans+=blabla.charAt(i);
                break;
        }
    }
return ans;
}


public static String translateHeEn(String blabla){
    String ans = "";
    for (int i = 0; i < blabla.length(); i++) {
        switch (blabla.charAt(i)) {
            case '/':
                ans+="q";
                break;
            case (char)39:
                ans+="w";
                break;
            case 'ק':
                ans+="e";
                break;
            case 'ר':
                ans+="r";
                break;
            case 'א':
                ans+="t";
                break;
            case 'ט':
                ans+="y";
                break;
            case 'ו':
                ans+="u";
                break;
            case 'ן':
                ans+="i";
                break;
            case 'ם':
                ans+="o";
                break;
            case 'פ':
                ans+="p";
                break;
            case ']':
                ans+="[";
                break;
            case '[':
                ans+="]";
                break;
            case '}':
                ans+="{";
                break;
            case '{':
                ans+="}";
                break;
            case 'ש':
                ans+="a";
                break;
            case 'ד':
                ans+="s";
                break;
            case 'ג':
                ans+="d";
                break;
            case 'כ':
                ans+="f";
                break;
            case 'ע':
                ans+="g";
                break;
            case 'י':
                ans+="h";
                break;
            case 'ח':
                ans+="j";
                break;
            case 'ל':
                ans+="k";
                break;
            case 'ך':
                ans+="l";
                break;
            case 'ף':
                ans+=";";
                break;
            case ',':
                ans+="'";
                break;
            case 'ז':
                ans+="z";
                break;
            case 'ס':
                ans+="x";
                break;
            case 'ב':
                ans+="c";
                break;
            case 'ה':
                ans+="v";
                break;
            case 'נ':
                ans+="b";
                break;
            case 'מ':
                ans+="n";
                break;
            case 'צ':
                ans+="m";
                break;
            case 'ת':
                ans+=",";
                break;
            case '>':
                ans+="<";
                break;
            case 'ץ':
                ans+=".";
                break;
            case '<':
                ans+=">";
                break;
            case '.':
                ans+="/";
                break;
            
                default:
                ans+=blabla.charAt(i);
                break;
        }
    }
return ans;
}


}