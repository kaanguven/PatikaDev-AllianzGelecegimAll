public class Employee {
    //nitelikler
    String name;
    double salary;
    int workHours;
    int hireYear;

    Employee(String name,double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }
    //Maaşa uygulanan vergiyi hesaplayacaktır.
    public double tax(){
        double tax =0;
        if(salary > 1000){
            tax += (salary * 3)/100;
        }else {
            tax = 0;
        }
        return tax;
    }
    /*
        Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı her saat başına
        30 TL olacak şekilde bonus ücretleri hesaplayacaktır.

     */
    public double bonus(){
        double bonus = 0;
        if (workHours > 40){
            bonus = (workHours - bonus) * 30;
        }else {
            bonus =0;
        }
        return bonus;
    }

    //Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
    public double raiseSalary () {
        double increasedSalary = 0;
        if ((2021 - hireYear) < 10 ) {
            increasedSalary += (salary * 5) / 100;
        }
        if (((2021 - hireYear) > 9) && ((2021 - hireYear) < 20)) {
            increasedSalary += (salary * 10) / 100;
        }
        if ((2021 - hireYear) > 19) {
            increasedSalary += (salary * 15) / 100;
        }
        return increasedSalary;
    }

    public void printInfo() {
        System.out.println("---------------------------");
        System.out.println("Adı : " + this.name);
        System.out.println("Maaşı  : " + this.salary);
        System.out.println("Çalışma Saati : " + this.workHours);
        System.out.println("Başlangıç Yılı : " + this.hireYear);
        System.out.println("Vergi  : " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Maaş Artışı : " + raiseSalary());
        System.out.println("Vergi ve Bonuslar ile birlikte maaş : " + (salary + bonus() - tax()));
        System.out.println("Toplam Maaş : " + (salary +  raiseSalary()));
    }

}