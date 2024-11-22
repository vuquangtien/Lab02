package Lab03.AimProjects.Source.test.disc;

import Lab03.AimProjects.Source.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cindrellaDVD = new DigitalVideoDisc("Cindrella");

        swap(jungleDVD, cindrellaDVD);
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cindrella DVD title: " + cindrellaDVD.getTitle());

        DVDWrapper dvdWrapper1 = new DVDWrapper(jungleDVD);
        DVDWrapper dvdWrapper2 = new DVDWrapper(cindrellaDVD);
        swap(dvdWrapper1, dvdWrapper2);
        System.out.println("Jungle DVD title: " + dvdWrapper1.dvd.getTitle());
        System.out.println("Cindrella DVD title: " + dvdWrapper2.dvd.getTitle());


        changeTitle(jungleDVD, cindrellaDVD.getTitle());
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }


    public static void swap(DVDWrapper dvdWrapper1, DVDWrapper dvdWrapper2) {
        DigitalVideoDisc dvdTemp = dvdWrapper1.dvd;
        dvdWrapper1.dvd = dvdWrapper2.dvd;
        dvdWrapper2.dvd = dvdTemp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

class DVDWrapper {
    DigitalVideoDisc dvd;

    DVDWrapper(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}

