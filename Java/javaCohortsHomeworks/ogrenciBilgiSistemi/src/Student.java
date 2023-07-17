public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;
    double yazili;
    double sozlu;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya,int sozluMat,int sozluFizik, int sozluKimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
            this.mat.sozlu=sozluMat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
            this.fizik.sozlu=sozluFizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
            this.kimya.sozlu=sozluKimya;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.sozlu = ((this.fizik.sozlu + this.kimya.sozlu + this.mat.sozlu) * 0.2) / 3;
        this.yazili = ((this.fizik.note + this.kimya.note + this.mat.note) * 0.8) / 3;

        System.out.println(this.sozlu+"#############");
        this.avarage = (this.yazili+this.sozlu);
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note+"Sözlü notları: "+this.mat.sozlu);
        System.out.println("Fizik Notu : " + this.fizik.note+"Sözlü notları: "+this.fizik.sozlu);
        System.out.println("Kimya Notu : " + this.kimya.note+"Sözlü notları: "+this.kimya.sozlu);
    }

}