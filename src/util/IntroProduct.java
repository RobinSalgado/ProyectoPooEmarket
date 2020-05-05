package util;

import enums.GenderType;
import enums.ProductBrands;
import enums.ProductType;
import info.ProductInfo;

import java.util.Scanner;

public class IntroProduct {
    private InitilizeProducts products;

    public IntroProduct(){ products = new InitilizeProducts();}
    public void RegProduct(){
        ProductInfo newProduct = new ProductInfo();
        Scanner kb = new Scanner(System.in);
        System.out.println("Introduzca un nombre de producto: ");
        String sProduct = kb.nextLine();
        newProduct.setProductName(sProduct);

        System.out.println("Introduzca el precio del producto: ");
        double dProduct = kb.nextDouble();
        newProduct.setCost(dProduct);

        System.out.println("Introduzca descipcion del producto: ");
        sProduct = kb.nextLine();
        newProduct.setProductName(sProduct);

        System.out.println("Introduzca un nombre de producto: ");
        sProduct = kb.nextLine();
        newProduct.setProductName(sProduct);

        System.out.println("Introduzca tipo de producto: \nOPCIONES: \n1)ROPA\n2)CELULARES");
        int iProduct = kb.nextInt();
        switch (iProduct){
            case 1:
                newProduct.setProductType(ProductType.ROPA);
            case 2:
                newProduct.setProductType(ProductType.CELULARES);
        }

        System.out.println("Introduzca marca de producto: ");
        switch (iProduct){
            case 1:
                System.out.println("OPCIONES: \n1) NIKE\n2) PUMA\n3) ADIDAS\n4) VANS\n5) AEROPOSTALE");
                iProduct = kb.nextInt();
                switch (iProduct){
                    case 1:
                        newProduct.setProductBrand(ProductBrands.NIKE);
                    case 2:
                        newProduct.setProductBrand(ProductBrands.PUMA);
                    case 3:
                        newProduct.setProductBrand(ProductBrands.ADIDAS);
                    case 4:
                        newProduct.setProductBrand(ProductBrands.VANS);
                    case 5:
                        newProduct.setProductBrand(ProductBrands.AEROPOSTALE);
                }
            case 2:
                System.out.println("OPCIONES: \n1) APPLE\n2) SAMSUNG\n3) HUAWEI\n4) MOTOROLA");
                iProduct = kb.nextInt();
                switch (iProduct){
                    case 1:
                        newProduct.setProductBrand(ProductBrands.APPLE);
                    case 2:
                        newProduct.setProductBrand(ProductBrands.SAMSUNG);
                    case 3:
                        newProduct.setProductBrand(ProductBrands.HUAWEI);
                    case 4:
                        newProduct.setProductBrand(ProductBrands.MOTOROLA);
                }
        }

        System.out.println("Introduzca Genero de producto: \n1) HOMBRE\n2) MUJER\n3) UNISEX");
        iProduct = kb.nextInt();
        switch (iProduct){
            case 1:
                newProduct.setGenderType(GenderType.HOMBRE);
            case 2:
                newProduct.setGenderType(GenderType.MUJER);
            case 3:
                newProduct.setGenderType(GenderType.UNISEX);
        }

        this.products.addProduct(newProduct);
    }//Fin de registro de producto.

}
