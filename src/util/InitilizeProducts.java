package util;

import enums.GenderType;
import enums.ProductBrands;
import enums.ProductType;
import info.ProductInfo;
import user.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Esta clase servira para inicializar productos que el usuario pueda ver al empezar el programa.
 */
public class InitilizeProducts extends genID{
    Map<String, ProductInfo> products;

    public InitilizeProducts() {
        this.products = new HashMap<>();
    }

    public void loadProducts(){
        //AEROPOSTALE
        ProductInfo p1 = new ProductInfo();
        p1.setProductID(genID("Producto"));
        p1.setProductName("Aéropostale cuello redondo.");
        p1.setCost(239.20);
        p1.setDescription("Playera blanca de manga corta marca Aéropostale.");
        p1.setProductType(ProductType.ROPA);
        p1.setProductBrand(ProductBrands.AÉROPOSTALE);
        p1.setGenderType(GenderType.HOMBRE);
        products.put(p1.getProductID(), p1);
        ///
        ProductInfo p2 = new ProductInfo();
        p2.setProductID(genID("Producto"));
        p2.setProductName("Aéropostale cuello redondo.");
        p2.setCost(239.20);
        p2.setDescription("Playera azul marino de manga corta marca Aéropostale.");
        p2.setProductType(ProductType.ROPA);
        p2.setProductBrand(ProductBrands.AÉROPOSTALE);
        p2.setGenderType(GenderType.HOMBRE);
        products.put(p2.getProductID(), p2);
        ///
        ProductInfo p3 = new ProductInfo();
        p3.setProductID(genID("Producto"));
        p3.setProductName("Aéropostale cuello redondo.");
        p3.setCost(319.20);
        p3.setDescription("Playera a rayas de manga corta marca Aéropostale.");
        p3.setProductType(ProductType.ROPA);
        p3.setProductBrand(ProductBrands.AÉROPOSTALE);
        p3.setGenderType(GenderType.HOMBRE);
        products.put(p3.getProductID(), p3);

        //VANS
        ProductInfo p4 = new ProductInfo();
        p4.setProductID(genID("Producto"));
        p4.setProductName("Vans classic logo black.");
        p4.setCost(250.00);
        p4.setDescription("Playera Vans Classic logo color negro.");
        p4.setProductType(ProductType.ROPA);
        p4.setProductBrand(ProductBrands.VANS);
        p4.setGenderType(GenderType.HOMBRE);
        products.put(p4.getProductID(), p4);
        ///
        ProductInfo p5 = new ProductInfo();
        p5.setProductID(genID("Producto"));
        p5.setProductName("Vans Ward negros.");
        p5.setCost(999.00);
        p5.setDescription("Tenis Vans Ward color negro para hombre.");
        p5.setProductType(ProductType.ROPA);
        p5.setProductBrand(ProductBrands.VANS);
        p5.setGenderType(GenderType.HOMBRE);
        products.put(p5.getProductID(), p5);
        ///
        ProductInfo p6 = new ProductInfo();
        p6.setProductID(genID("Producto"));
        p6.setProductName("Vans MW Asher rosas.");
        p6.setCost(999.00);
        p6.setDescription("Tenis Vans MW Asher color rosa para mujer.");
        p6.setProductType(ProductType.ROPA);
        p6.setProductBrand(ProductBrands.VANS);
        p6.setGenderType(GenderType.MUJER);
        products.put(p6.getProductID(), p6);
        ///

        //ADIDAS
        ProductInfo p7 = new ProductInfo();
        p7.setProductID(genID("Producto"));
        p7.setProductName("Adidas Run Faalcon.");
        p7.setCost(1104.15);
        p7.setDescription("Tenis Adidas Run Falcon rosas.");
        p7.setProductType(ProductType.ROPA);
        p7.setProductBrand(ProductBrands.ADIDAS);
        p7.setGenderType(GenderType.MUJER);
        products.put(p7.getProductID(), p7);
        ///
        ProductInfo p8 = new ProductInfo();
        p8.setProductID(genID("Producto"));
        p8.setProductName("Short adidas correr.");
        p8.setCost(424.12);
        p8.setDescription("Short adidas para correr color negro para mujer.");
        p8.setProductType(ProductType.ROPA);
        p8.setProductBrand(ProductBrands.ADIDAS);
        p8.setGenderType(GenderType.MUJER);
        products.put(p8.getProductID(), p8);
        ///
        ProductInfo p9 = new ProductInfo();
        p9.setProductID(genID("Producto"));
        p9.setProductName("Adidas Lite Racer.");
        p9.setCost(1200.98);
        p9.setDescription("Adidas Lite Racer reborn para hombre.");
        p9.setProductType(ProductType.ROPA);
        p9.setProductBrand(ProductBrands.ADIDAS);
        p9.setGenderType(GenderType.HOMBRE);
        products.put(p9.getProductID(), p9);
        ///

        //PUMA
        ProductInfo p10 = new ProductInfo();
        p10.setProductID(genID("Producto"));
        p10.setProductName("Short Puma para correr.");
        p10.setCost(404.52);
        p10.setDescription("Short Puma color negro para hombre.");
        p10.setProductType(ProductType.ROPA);
        p10.setProductBrand(ProductBrands.PUMA);
        p10.setGenderType(GenderType.MUJER);
        products.put(p10.getProductID(), p10);
        ///
        ProductInfo p11 = new ProductInfo();
        p11.setProductID(genID("Producto"));
        p11.setProductName("Sudadera Puma.");
        p11.setCost(939.32);
        p11.setDescription("Sudadera puma color purpura para mujer.");
        p11.setProductType(ProductType.ROPA);
        p11.setProductBrand(ProductBrands.PUMA);
        p11.setGenderType(GenderType.MUJER);
        products.put(p11.getProductID(), p11);
        ///
        ProductInfo p12 = new ProductInfo();
        p12.setProductID(genID("Producto"));
        p12.setProductName("Sandalias puma Epic Flip.");
        p12.setCost(424.15);
        p12.setDescription("Sandalias Puma para natacion.");
        p12.setProductType(ProductType.ROPA);
        p12.setProductBrand(ProductBrands.PUMA);
        p12.setGenderType(GenderType.UNISEX);
        products.put(p12.getProductID(), p12);
        ///

        //NIKE
        ProductInfo p13 = new ProductInfo();
        p13.setProductID(genID("Producto"));
        p13.setProductName("Short NIKE para correr.");
        p13.setCost(625.32);
        p13.setDescription("Short NIKE color negro para hombre.");
        p13.setProductType(ProductType.ROPA);
        p13.setProductBrand(ProductBrands.NIKE);
        p13.setGenderType(GenderType.MUJER);
        products.put(p13.getProductID(), p13);
        ///
        ProductInfo p14 = new ProductInfo();
        p14.setProductID(genID("Producto"));
        p14.setProductName("Sudadera NIKE.");
        p14.setCost(865.32);
        p14.setDescription("Sudadera NIKE color purpura para mujer.");
        p14.setProductType(ProductType.ROPA);
        p14.setProductBrand(ProductBrands.NIKE);
        p14.setGenderType(GenderType.MUJER);
        products.put(p14.getProductID(), p14);
        ///
        ProductInfo p15 = new ProductInfo();
        p15.setProductID(genID("Producto"));
        p15.setProductName("Sandalias NIKE Epic Flip.");
        p15.setCost(754.63);
        p15.setDescription("Sandalias NIKE para natacion.");
        p15.setProductType(ProductType.ROPA);
        p15.setProductBrand(ProductBrands.NIKE);
        p15.setGenderType(GenderType.UNISEX);
        products.put(p15.getProductID(), p15);
        ///

        //APPLE
        ProductInfo p16 = new ProductInfo();
        p16.setProductID(genID("Producto"));
        p16.setProductName("Iphone X.");
        p16.setCost(10_898.00);
        p16.setDescription("Apple iPhone X, 64GB, Silver Fully unlocked Desbloqueado.");
        p16.setProductType(ProductType.CELULARES);
        p16.setProductBrand(ProductBrands.APPLE);
        p16.setGenderType(GenderType.UNISEX);
        products.put(p16.getProductID(), p16);
        ///
        ProductInfo p17 = new ProductInfo();
        p17.setProductID(genID("Producto"));
        p17.setProductName("Iphone 11.");
        p17.setCost(18_599.00);
        p17.setDescription("Apple iPhone 11 64 GB Purple.");
        p17.setProductType(ProductType.CELULARES);
        p17.setProductBrand(ProductBrands.APPLE);
        p17.setGenderType(GenderType.UNISEX);
        products.put(p17.getProductID(), p17);

        //SAMSUNG
        ProductInfo p18 = new ProductInfo();
        p18.setProductID(genID("Producto"));
        p18.setProductName("SAMSUNG Galaxy A71.");
        p18.setCost(8_948.99);
        p18.setDescription("SAMSUNG Galaxy A71 128Gb Azul Desbloqueado.");
        p18.setProductType(ProductType.CELULARES);
        p18.setProductBrand(ProductBrands.SAMSUNG);
        p18.setGenderType(GenderType.UNISEX);
        products.put(p18.getProductID(), p18);
        ///
        ProductInfo p19 = new ProductInfo();
        p19.setProductID(genID("Producto"));
        p19.setProductName("Galaxy S20.");
        p19.setCost(29_999);
        p19.setDescription("Galaxy S20 Ultra Cosmic Black.");
        p19.setProductType(ProductType.CELULARES);
        p19.setProductBrand(ProductBrands.SAMSUNG);
        p19.setGenderType(GenderType.UNISEX);
        products.put(p19.getProductID(), p19);
        ///

        //HUAWEI
        ProductInfo p20 = new ProductInfo();
        p20.setProductID(genID("Producto"));
        p20.setProductName("Huawei P30 Pro.");
        p20.setCost(14_499.00);
        p20.setDescription("Smartphone 6.47” FHD+, 40MP Leica Quad Camera, 256 GB.");
        p20.setProductType(ProductType.CELULARES);
        p20.setProductBrand(ProductBrands.HUAWEI);
        p20.setGenderType(GenderType.UNISEX);
        products.put(p20.getProductID(), p20);
        ///
        ProductInfo p21 = new ProductInfo();
        p21.setProductID(genID("Producto"));
        p21.setProductName("Huawei Nova 5T.");
        p21.setCost(10_246.97);
        p21.setDescription("8GB+128GB, 6.26\" Punch All-View Display, Color Azul.");
        p21.setProductType(ProductType.CELULARES);
        p21.setProductBrand(ProductBrands.HUAWEI);
        p21.setGenderType(GenderType.UNISEX);
        products.put(p21.getProductID(), p21);
        ///

        //MOTOROLA
        ProductInfo p22 = new ProductInfo();
        p22.setProductID(genID("Producto"));
        p22.setProductName("Motorola One Hyper.");
        p22.setCost(8_999);
        p22.setDescription("128 GB Azul Iceberg.");
        p22.setProductType(ProductType.CELULARES);
        p22.setProductBrand(ProductBrands.MOTOROLA);
        p22.setGenderType(GenderType.UNISEX);
        products.put(p22.getProductID(), p22);
    }
}
