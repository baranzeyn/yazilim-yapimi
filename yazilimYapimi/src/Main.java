import java.util.ArrayList;
//kullanıcı yaparsa
import java.util.Scanner;

public class Main {
	public static int hesaplama(int sonuc, int hedef) {
		int fark = hedef - sonuc;
		if (fark == 2 || fark == -2) {
			return 8;
		} else if (fark == 1 || fark == -1) {
			return 9;
		} else if (fark == 0) {
			return 10;
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> sayilar2 = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		int hedef = (int) (Math.random() * 1000);
		sayilar2.add((int) (Math.random() * (90) + 10));
		boolean isRun = true;
		int sonuc = 0;
		for (int i = 0; i < 5; i++) {
			int a = (int) (Math.random() * 10);
			sayilar2.add(a);
		}
		System.out.println("hedef:" + hedef);

		while (isRun) {
			for (int i = 0; i < sayilar2.size(); i++) {
				System.out.println((i + 1) + ")" + sayilar2.get(i));
			}
			System.out.println("Kullanacağınız sayıların numaralarını giriniz:");
			int secim1 = scan.nextInt();
			int secim2 = scan.nextInt();
			/* alınan değer index no+1 olduğu için -1li olan hali alınır */
			int sayi1 = sayilar2.get(secim1 - 1);
			int sayi2 = sayilar2.get(secim2 - 1);

			// kullanılacak sayılar arraylistten silinir
			sayilar2.remove(secim1 - 1);// **

			if (secim2 - 1 == 0) {
				sayilar2.remove(secim2 - 1);// zaten seçilen elemanın indexi sıfırsa bu azalmadan index numarası olarak
											// etkilenmez
			} else {
				// yıldızlı işlem sonrası toplam index numaraları bir azalır.Çünkü toplam eleman
				// sayısı azalır.
				sayilar2.remove(secim2 - 2);
			}

			System.out.println(
					"Yapmak istediğininiz işlemi seçiniz\n1-Toplama\n2-Çıkarma\n3-çarpma\n4-Bölme\n5-İşlem yapma");
			int secim = scan.nextInt();
			switch (secim) {
			case 1:
				sonuc = sayi1 + sayi2;
				System.out.println("elde edilen sonuc:" + sonuc);
				break;
			case 2:
				sonuc = sayi1 - sayi2;
				System.out.println("elde edilen sonuc:" + sonuc);
				break;
			case 3:
				sonuc = (sayi1 * sayi2);
				System.out.println("elde edilen sonuc:" + sonuc);
				break;
			case 4:
				if (sayi2 != 0) {
					sonuc = sayi1 / sayi2;
					System.out.println("elde edilen sonuc:" + sonuc);
					break;
				} else {
					System.out.println("sonuç hesaplanamaz");
					System.exit(0);
				}
				break;
			case 5:
				System.out.println("İşlem dizisinden çıkılıyor...");
				break;
			}

			// elde edilen sonuc arrayliste eklenir
			sayilar2.add(sonuc);

			if (secim == 5) {
				isRun = false;
			}

		}
		System.out.println(hesaplama(sonuc, hedef));
	}

}
