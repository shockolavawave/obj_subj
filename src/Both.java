public class Both {

    private boolean O = true;          // control for Objective attraction
    private boolean S = true;          // control for Subjective attraction
    private char attrib = 'a';        // takes value {a, b, c, d} based on both O and S

    public boolean isO() {  return O;   }
    public void setO(boolean o) {   O = o;  }

    public boolean isS() {  return S;   }
    public void setS(boolean s) {   S = s;  }

    public char getAttrib() {   return attrib;  }
    public void setAttrib(char attrib) {    this.attrib = attrib;   }

}
