package com.hmkcode.android.sign;

public class Form {
	public boolean validate(String desc, String cat, String subCat, String company){
		//if (desc.trim().compareTo("") == 0)
		//	return false;
		
		if(cat.equals("Electronics")){
			if (subCat.equals("Laptop")||subCat.equals("Cellphone")||subCat.equals("Tablet/iPad")||subCat.equals("iPod/MP3 player"))
				return true;
		}
		else if(cat.equals("Clothing")){
			if (subCat.equals("Jacket/Coat")||subCat.equals("Gloves")||subCat.equals("Shoes"))
				return true;
		}
		else if(cat.equals("Accessories")){
			if (subCat.equals("Jewellery")||subCat.equals("Watch")||subCat.equals("Glasses"))
				return true;
		}
		else if(cat.equals("Keys") && company.equals("N/A")){
			if (subCat.equals("N/A"))
				return true;
		}
		else if(cat.equals("Backpack")||cat.equals("Purse/Wallet")){
				if (subCat.equals("N/A"))
					return true;
		}
		return false;
	}
}
