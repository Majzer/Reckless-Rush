//https://github.com/tuskeb/mester
package com.mygdx.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {
	// https://github.com/libgdx/libgdx/wiki/Managing-your-assets
	// http://www.jacobplaster.net/using-libgdx-asset-manager
	// https://www.youtube.com/watch?v=JXThbQir2gU
	// https://github.com/Matsemann/libgdx-loading-screen/blob/master/Main/src/com/matsemann/libgdxloadingscreen/screen/LoadingScreen.java

	public static AssetManager manager;
	public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


	static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
	static {
		fontParameter.fontFileName = "arial.ttf";
		fontParameter.fontParameters.size = 30;
		fontParameter.fontParameters.characters = CHARS;
		fontParameter.fontParameters.color = Color.WHITE;
	}


	//Betútípus
	public static final AssetDescriptor<BitmapFont> ARIAL_30_FONT
			= new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);

	//Animáciok
	public static final AssetDescriptor<TextureAtlas> WALK_TEXTURE
			= new AssetDescriptor<TextureAtlas>("pedestrian_project/walk.atlas", TextureAtlas.class);

	//Autó ép
	public static final AssetDescriptor<Texture> B_ELSO_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/elso_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_ORR_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/orr_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_HATSO_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/hatso_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_SEGG_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> B_OLDAL_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/oldal_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> J_ELSO_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/elso_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_ORR_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/orr_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_HATSO_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/hatso_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_SEGG_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> J_OLDAL_EP
			= new AssetDescriptor<Texture>("car_sprite/intact/oldal_jobb.png",Texture.class);

	//Autó törött
	public static final AssetDescriptor<Texture> B_ELSO_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/elso_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_ORR_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/orr_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_HATSO_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/hatso_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> B_SEGG_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> B_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/oldal_bal.png",Texture.class);
	public static final AssetDescriptor<Texture> J_ELSO_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/elso_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_ORR_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/orr_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_HATSO_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/hatso_jobb.png",Texture.class);
	public static final AssetDescriptor<Texture> J_SEGG_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> J_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("car_sprite/damage/oldal_jobb.png",Texture.class);

    //Autó 2 ép
    public static final AssetDescriptor<Texture> KEK_B_ELSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_ORR_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_HATSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_SEGG_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_OLDAL_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ELSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ORR_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_HATSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_SEGG_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_OLDAL_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_segg.png",Texture.class);

    //Autó 2 törött
    public static final AssetDescriptor<Texture> KEK_B_ELSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_ORR_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_HATSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_SEGG_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_OLDAL_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ELSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ORR_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_HATSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_SEGG_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_OLDAL_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_segg.png",Texture.class);

    //Teszt
	public static final AssetDescriptor<Texture> TESZT_TEXTURE
			= new AssetDescriptor<Texture>("test.png",Texture.class);

	//Kamion ép
	public static final AssetDescriptor<Texture> KAMION_B_ELSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_ORR_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_HATSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_SEGG_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_OLDAL_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ELSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ORR_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_HATSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_SEGG_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_OLDAL_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_segg.png",Texture.class);

	//Autó 2 törött
	public static final AssetDescriptor<Texture> KAMION_B_ELSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_ORR_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_HATSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_SEGG_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ELSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ORR_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_HATSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_SEGG_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_segg.png",Texture.class);

	//Háttér
	public static final AssetDescriptor<Texture> HATTER_TEXTURE
			=new AssetDescriptor<Texture>("sprites/road_background.png",Texture.class);

	//Bokor
	public static final AssetDescriptor<Texture> BOKOR_EP_TEXTURE
			=new AssetDescriptor<Texture>("sprites/bush_project.png",Texture.class);
	public static final AssetDescriptor<Texture> BOKOR_LAPOS_TEXTURE
			=new AssetDescriptor<Texture>("sprites/damaged_bush_project.png",Texture.class);


    public static void prepare() {
		manager = new AssetManager();
		Texture.setAssetManager(manager);
	}



	public static void load() {
		FileHandleResolver resolver = new InternalFileHandleResolver();
		manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
		manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
		manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));


		manager.load(ARIAL_30_FONT);

		//Animáciok
		manager.load(WALK_TEXTURE);

		//Autó ép
		manager.load(B_ELSO_EP);
		manager.load(B_ORR_EP);
		manager.load(B_HATSO_EP);
		manager.load(B_SEGG_EP);
		manager.load(B_OLDAL_EP);
		manager.load(J_ELSO_EP);
		manager.load(J_ORR_EP);
		manager.load(J_HATSO_EP);
		manager.load(J_SEGG_EP);
		manager.load(J_OLDAL_EP);

		//Autó törött
		manager.load(B_ELSO_TOROTT);
		manager.load(B_ORR_TOROTT);
		manager.load(B_HATSO_TOROTT);
		manager.load(B_SEGG_TOROTT);
		manager.load(B_OLDAL_TOROTT);
		manager.load(J_ELSO_TOROTT);
		manager.load(J_ORR_TOROTT);
		manager.load(J_HATSO_TOROTT);
		manager.load(J_SEGG_TOROTT);
		manager.load(J_OLDAL_TOROTT);


		//Autó Kék(2) ép
		manager.load(KEK_B_ELSO_EP);
		manager.load(KEK_B_ORR_EP);
		manager.load(KEK_B_HATSO_EP);
		manager.load(KEK_B_SEGG_EP);
		manager.load(KEK_B_OLDAL_EP);
		manager.load(KEK_J_ELSO_EP);
		manager.load(KEK_J_ORR_EP);
		manager.load(KEK_J_HATSO_EP);
		manager.load(KEK_J_SEGG_EP);
		manager.load(KEK_J_OLDAL_EP);

		//Autó Kék(2) törött
		manager.load(KEK_B_ELSO_TOROTT);
		manager.load(KEK_B_ORR_TOROTT);
		manager.load(KEK_B_HATSO_TOROTT);
		manager.load(KEK_B_SEGG_TOROTT);
		manager.load(KEK_B_OLDAL_TOROTT);
		manager.load(KEK_J_ELSO_TOROTT);
		manager.load(KEK_J_ORR_TOROTT);
		manager.load(KEK_J_HATSO_TOROTT);
		manager.load(KEK_J_SEGG_TOROTT);
		manager.load(KEK_J_OLDAL_TOROTT);

		//Kamion ép
		manager.load(KAMION_B_ELSO_EP);
		manager.load(KAMION_B_ORR_EP);
		manager.load(KAMION_B_HATSO_EP);
		manager.load(KAMION_B_SEGG_EP);
		manager.load(KAMION_B_OLDAL_EP);
		manager.load(KAMION_J_ELSO_EP);
		manager.load(KAMION_J_ORR_EP);
		manager.load(KAMION_J_HATSO_EP);
		manager.load(KAMION_J_SEGG_EP);
		manager.load(KAMION_J_OLDAL_EP);

		//Kamion törött
		manager.load(KAMION_B_ELSO_TOROTT);
		manager.load(KAMION_B_ORR_TOROTT);
		manager.load(KAMION_B_HATSO_TOROTT);
		manager.load(KAMION_B_SEGG_TOROTT);
		manager.load(KAMION_B_OLDAL_TOROTT);
		manager.load(KAMION_J_ELSO_TOROTT);
		manager.load(KAMION_J_ORR_TOROTT);
		manager.load(KAMION_J_HATSO_TOROTT);
		manager.load(KAMION_J_SEGG_TOROTT);
		manager.load(KAMION_J_OLDAL_TOROTT);

		//Teszt
		manager.load(TESZT_TEXTURE);

		//Háttér
		manager.load(HATTER_TEXTURE);

		//Bokor
		manager.load(BOKOR_EP_TEXTURE);
		manager.load(BOKOR_LAPOS_TEXTURE);

	}

    public static void afterLoaded() {
        //manager.get(MUSIC).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
