package Work1.Day07.Example6_7;

/**
 * ********概述：
 */
public class AdvertisementBoard {
    Advertisement adver;

    public void setAdvertisement(Advertisement adver) {
        this.adver = adver;
    }
    public void show() {
        if (adver == null) {
            System.out.println("广告招商中");
        }else {
            adver.showAdvertisement();
        }
    }
}
