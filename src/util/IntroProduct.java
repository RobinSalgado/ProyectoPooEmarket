package util;

import enums.GenderType;
import enums.ProductBrands;
import enums.ProductType;
import info.ProductInfo;
import user.Menus;

import java.util.Scanner;

public class IntroProduct {
    public IntroProduct(){}
    
    public void RegProduct(InitializeProducts products){
    	System.out.println(); //Espaciado--
        ProductInfo newProduct = new ProductInfo();
        Scanner kb = new Scanner(System.in);
        System.out.println("Introduzca un nombre de producto: ");
        String sProduct = kb.nextLine();
        newProduct.setProductName(sProduct);

        System.out.println("Introduzca el precio del producto: ");
        String dProduct = kb.nextLine();
        newProduct.setCost(Double.valueOf(dProduct));

        System.out.println("Introduzca descripcion del producto: ");
        sProduct = kb.nextLine();
        newProduct.setProductName(sProduct);

        System.out.println();//Espaciado--
        System.out.println("Introduzca tipo de producto: \nOPCIONES: \n1)ROPA\n2)CELULARES");
        String iProduct = kb.nextLine();
        while(!Menus.isNumber(iProduct.charAt(0), kb)) {
            System.out.println("Opcion invalida");//Espaciado--
            System.out.println("Introduzca tipo de producto: \nOPCIONES: \n1)ROPA\n2)CELULARES");
            iProduct = kb.nextLine();
        }
        switch (Integer.valueOf(iProduct)){
            case 1:
                newProduct.setProductType(ProductType.ROPA);
                break;
            case 2:
                newProduct.setProductType(ProductType.CELULARES);
                break;
        }
        Integer op = Integer.valueOf(iProduct);
        System.out.println("Introduzca marca de producto: ");
        switch (op){
            case 1:
                clothesBrands(newProduct); 
                break;
            case 2:
                cellphonesBrands(newProduct);
                break;
        }
        if(op == 1) {
            System.out.println("Introduzca Genero de producto: \n1) HOMBRE\n2) MUJER\n3) UNISEX");
            iProduct = kb.nextLine();
            while (!Menus.isNumber(iProduct.charAt(0), kb)) {
                System.out.println("Opcion invalida");//Espaciado--
                System.out.println("Introduzca tipo de producto: \nOPCIONES: \n1)ROPA\n2)CELULARES");
                iProduct = kb.nextLine();
            }
            switch (Integer.valueOf(iProduct)) {
                case 1:
                    newProduct.setGenderType(GenderType.HOMBRE);
                case 2:
                    newProduct.setGenderType(GenderType.MUJER);
                case 3:
                    newProduct.setGenderType(GenderType.UNISEX);
            }
        }
        System.out.println("Introduce stock del producto: ");
        iProduct = kb.nextLine();;
        newProduct.setProductStock(Integer.valueOf(iProduct));

        products.addProduct(newProduct);
    }//Fin de registro de producto.


    private void clothesBrands(ProductInfo newProduct) {
        System.out.println("OPCIONES: \n1) NIKE\n2) PUMA\n3) ADIDAS\n4) VANS\n5) AEROPOSTALE");
        Scanner kb = new Scanner(System.in);
        Integer iProduct = kb.nextInt();
        switch (iProduct){
            case 1:
                newProduct.setProductBrand(ProductBrands.NIKE);
                break;
            case 2:
                newProduct.setProductBrand(ProductBrands.PUMA);
                break;
            case 3:
                newProduct.setProductBrand(ProductBrands.ADIDAS);
                break;
            case 4:
                newProduct.setProductBrand(ProductBrands.VANS);
                break;
            case 5:
                newProduct.setProductBrand(ProductBrands.AEROPOSTALE);
                break;
        }
    }

    private void cellphonesBrands(ProductInfo newProduct) {
        System.out.println("OPCIONES: \n1) APPLE\n2) SAMSUNG\n3) HUAWEI\n4) MOTOROLA");
        Scanner kb = new Scanner(System.in);
        Integer iProduct = kb.nextInt();
        switch (iProduct) {
            case 1:
                newProduct.setProductBrand(ProductBrands.APPLE);
                break;
            case 2:
                newProduct.setProductBrand(ProductBrands.SAMSUNG);
                break;
            case 3:
                newProduct.setProductBrand(ProductBrands.HUAWEI);
                break;
            case 4:
                newProduct.setProductBrand(ProductBrands.MOTOROLA);
                break;
        }
    }
}
