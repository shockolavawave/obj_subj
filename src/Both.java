public class Both {

    private boolean O;          // control for Objective attraction
    private boolean S;          // control for Subjective attraction
    private char attrib;        // takes value {a, b, c, d} based on both O and S

    public boolean isO() {  return O;   }
    public void setO(boolean o) {   O = o;  }

    public boolean isS() {  return S;   }
    public void setS(boolean s) {   S = s;  }

    public char getAttrib() {   return attrib;  }
    public void setAttrib(char attrib) {    this.attrib = attrib;   }

    public Both() {
        O = true;
        S = true;
        attrib = 'a';
    }
}
