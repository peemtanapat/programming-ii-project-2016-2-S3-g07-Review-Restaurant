package TEST2;

public class Score {

    private int taste;
    private int value;
    private int clean;
    private int look;
    private static int count;

    public Score(int taste, int value, int clean, int look) {
        this.taste = taste;
        this.value = value;
        this.clean = clean;
        this.look = look;
    }

    public static int getCount() {
        return count;
    }

    public double avg() {
        return (taste + value + clean + look) / 4;
    }

    public String par() {
        if (avg() >= 4.5) {
            return "ดีเยี่ยม";
        } else if (avg() >= 4) {
            return "ดีมาก";
        } else if (avg() >= 3.5) {
            return "ดี";
        } else if (avg() >= 3) {
            return "ค่อนข้างดี";
        } else if (avg() >= 2) {
            return "น่าพอใจ";
        } else if (avg() >= 1.5) {
            return "พอใช้";
        } else if (avg() >= 1) {
            return "ควรปรับปรุง";
        } else {
            return "ต่ำกว่าเกณฑ์ขั้นต่ำ";
        }

    }

    @Override
    public String toString() {
        String result2 = super.toString() + "\n"
                + "----------คะแนน----------"
                + "\nความอร่อย: " + taste + " "
                + "\nความคุ้มค่า: " + value + " "
                + "\nความสะอาด: " + clean + " "
                + "\nความน่ารับประทาน:" + look + " "
                + "\nคะแนนเฉลี่ย: " + avg()
                + "\nอยู่ในเกณฑ์..." + par();
        return result2;
    }
}
