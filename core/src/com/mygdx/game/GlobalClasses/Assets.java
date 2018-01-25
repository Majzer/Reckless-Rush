//https://github.com/tuskeb/mester
package com.mygdx.game.GlobalClasses;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
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

	//Zene
	public static final AssetDescriptor<Music> Miami_Soul
			= new AssetDescriptor<Music>("musics/Miami_Soul.mp3", Music.class);

	public static final AssetDescriptor<Music> ThemeSound
			= new AssetDescriptor<Music>("musics/ThemeSound.mp3", Music.class);


	//Animáciok
	public static final AssetDescriptor<TextureAtlas> WALK_TEXTURE
			= new AssetDescriptor<TextureAtlas>("pedestrian_project/no2/walk.atlas", TextureAtlas.class);

	public static final AssetDescriptor<Texture> BTN_START_TEXTURE
			= new AssetDescriptor<Texture>("menu/btn_start_vol2.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_START_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("menu/btn_start2_vol2.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_EXIT_TEXTURE
			= new AssetDescriptor<Texture>("menu/btn_exit2_vol2.png", Texture.class);

	public static final AssetDescriptor<Texture> BTN_EXIT_DOWN_TEXTURE
			= new AssetDescriptor<Texture>("menu/btn_exit_vol2.png", Texture.class);

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
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_HATSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_SEGG_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_OLDAL_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/bal_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ELSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ORR_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_HATSO_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_SEGG_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_OLDAL_EP
            = new AssetDescriptor<Texture>("car2_sprite/intact/jobb_kozep.png",Texture.class);

    //Autó 2 törött
    public static final AssetDescriptor<Texture> KEK_B_ELSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_ORR_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_HATSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_SEGG_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_B_OLDAL_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/bal_kozep.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ELSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_elso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_ORR_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_orr.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_HATSO_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_hatso.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_SEGG_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_segg.png",Texture.class);
    public static final AssetDescriptor<Texture> KEK_J_OLDAL_TOROTT
            = new AssetDescriptor<Texture>("car2_sprite/damage/jobb_kozep.png",Texture.class);

    //Teszt
	public static final AssetDescriptor<Texture> TESZT_TEXTURE
			= new AssetDescriptor<Texture>("test.png",Texture.class);

	//Kamion ép
	public static final AssetDescriptor<Texture> KAMION_B_ELSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_ORR_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_HATSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_SEGG_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_OLDAL_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/bal_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ELSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ORR_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_HATSO_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_SEGG_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_OLDAL_EP
			= new AssetDescriptor<Texture>("truck_sprite/intact/jobb_kozep.png",Texture.class);

	//Kamion törött
	public static final AssetDescriptor<Texture> KAMION_B_ELSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_ORR_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_HATSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_SEGG_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_B_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/bal_kozep.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ELSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_ORR_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_HATSO_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_SEGG_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> KAMION_J_OLDAL_TOROTT
			= new AssetDescriptor<Texture>("truck_sprite/damage/jobb_kozep.png",Texture.class);

	// TODO: 2018. 01. 23. Jobb közép és bal középre figyelj oda Bence
	//Rendőrkocsi ép
	public static final AssetDescriptor<Texture> RENDOR_B_ELSO_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_ORR_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_HATSO_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_SEGG_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_OLDAL_RED_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/bal_kozep_red.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_ELSO_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_ORR_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_HATSO_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_SEGG_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_OLDAL_BLUE_EP
			= new AssetDescriptor<Texture>("police_car_sprite/intact/jobb_kozep_blue.png",Texture.class);

	//Kamion törött
	public static final AssetDescriptor<Texture> RENDOR_B_ELSO_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/bal_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_ORR_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/bal_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_HATSO_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/bal_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_SEGG_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/bal_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_B_OLDAL_RED_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/bal_kozep_red.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_ELSO_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/jobb_elso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_ORR_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/jobb_orr.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_HATSO_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/jobb_hatso.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_SEGG_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/jobb_segg.png",Texture.class);
	public static final AssetDescriptor<Texture> RENDOR_J_OLDAL_BLUE_TOROTT
			= new AssetDescriptor<Texture>("police_car_sprite/damaged/jobb_kozep_blue.png",Texture.class);

	//Út
	public static final AssetDescriptor<Texture> ROAD_TEXTURE
			=new AssetDescriptor<Texture>("sprites/road_background_vol2.png",Texture.class);

	public static final AssetDescriptor<Texture> KANYAR_TEXTURE
			= new AssetDescriptor<Texture>("sprites/right_corner.png",Texture.class);

	public static final AssetDescriptor<Texture> JO_KANYAR_TEXTURE
			= new AssetDescriptor<Texture>("sprites/one_lane_good_road.png", Texture.class);

	//Út hibák
	public static final AssetDescriptor<Texture> KATYU1_TEXTURE
			= new AssetDescriptor<Texture>("sprites/road_object/pothole1.png", Texture.class);

	public static final AssetDescriptor<Texture> KATYU2_TEXTURE
			= new AssetDescriptor<Texture>("sprites/road_object/pothole2.png", Texture.class);

	public static final AssetDescriptor<Texture> KATYU3_TEXTURE
			= new AssetDescriptor<Texture>("sprites/road_object/pothole3.png", Texture.class);


	//Út melletti objaktumok
	public static final AssetDescriptor<Texture> HOUSE_TEXTURE
			= new AssetDescriptor<Texture>("sprites/road_object/house.png", Texture.class);

	//Háttér
	public static final AssetDescriptor<Texture> MENU_HATTER_TEXTURE
			=new AssetDescriptor<Texture>("sprites/menubg.png",Texture.class);

	//Bokor
	public static final AssetDescriptor<Texture> BOKOR_EP_TEXTURE
			=new AssetDescriptor<Texture>("sprites/bush_project.png",Texture.class);
	public static final AssetDescriptor<Texture> BOKOR_LAPOS_TEXTURE
			=new AssetDescriptor<Texture>("sprites/damaged_bush_project.png",Texture.class);

	//Logó
	public static final AssetDescriptor<Texture> LOGO1_TEXTURE
			=new AssetDescriptor<Texture>("logo/logo-1.png",Texture.class);
	public static final AssetDescriptor<Texture> LOGO2_TEXTURE
			=new AssetDescriptor<Texture>("logo/logo-2.png",Texture.class);
	public static final AssetDescriptor<Texture> LOGO3_TEXTURE
			=new AssetDescriptor<Texture>("logo/logo-3.png",Texture.class);

	//Robbanás
	public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTURE
			= new AssetDescriptor<TextureAtlas>("explosion.atlas", TextureAtlas.class);

	//Táblák
	public static final AssetDescriptor<Texture> BAK_15_TEXTURE
			=new AssetDescriptor<Texture>("signs/bak_15.png",Texture.class);

	public static final AssetDescriptor<Texture> BAK_35_TEXTURE
			=new AssetDescriptor<Texture>("signs/bak_35.png",Texture.class);

	public static final AssetDescriptor<Texture> KESZTHELY_TEXTURE
			=new AssetDescriptor<Texture>("signs/keszthely.png",Texture.class);

	public static final AssetDescriptor<Texture> LENTI_40_TEXTURE
			=new AssetDescriptor<Texture>("signs/lenti_40.png",Texture.class);

	public static final AssetDescriptor<Texture> LETENYE_35_TEXTURE
			=new AssetDescriptor<Texture>("signs/letenye_35.png",Texture.class);

	public static final AssetDescriptor<Texture> NAGYKANIZSA_40_TEXTURE
			=new AssetDescriptor<Texture>("signs/nagykanizsa_40.png",Texture.class);

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
		manager.load(BTN_START_TEXTURE);
		manager.load(BTN_START_DOWN_TEXTURE);
		manager.load(BTN_EXIT_TEXTURE);
		manager.load(BTN_EXIT_DOWN_TEXTURE);
		manager.load(EXPLOSION_TEXTURE);

		//Zene
		manager.load(Miami_Soul);
		manager.load(ThemeSound);

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

		//Rendőr ép
		manager.load(RENDOR_B_ELSO_EP);
		manager.load(RENDOR_B_ORR_EP);
		manager.load(RENDOR_B_HATSO_EP);
		manager.load(RENDOR_B_SEGG_EP);
		manager.load(RENDOR_B_OLDAL_RED_EP);
		manager.load(RENDOR_J_ELSO_EP);
		manager.load(RENDOR_J_ORR_EP);
		manager.load(RENDOR_J_HATSO_EP);
		manager.load(RENDOR_J_SEGG_EP);
		manager.load(RENDOR_J_OLDAL_BLUE_EP);

		//Rendőr törött
		manager.load(RENDOR_B_ELSO_TOROTT);
		manager.load(RENDOR_B_ORR_TOROTT);
		manager.load(RENDOR_B_HATSO_TOROTT);
		manager.load(RENDOR_B_SEGG_TOROTT);
		manager.load(RENDOR_B_OLDAL_RED_TOROTT);
		manager.load(RENDOR_J_ELSO_TOROTT);
		manager.load(RENDOR_J_ORR_TOROTT);
		manager.load(RENDOR_J_HATSO_TOROTT);
		manager.load(RENDOR_J_SEGG_TOROTT);
		manager.load(RENDOR_J_OLDAL_BLUE_TOROTT);

		//Teszt
		manager.load(TESZT_TEXTURE);

		//Út
		manager.load(ROAD_TEXTURE);
		manager.load(KANYAR_TEXTURE);
		manager.load(JO_KANYAR_TEXTURE);

		//Út hibák
		manager.load(KATYU1_TEXTURE);
		manager.load(KATYU2_TEXTURE);
		manager.load(KATYU3_TEXTURE);

		//Út melletti objektumok
		manager.load(HOUSE_TEXTURE);

		//Háttér
		manager.load(MENU_HATTER_TEXTURE);

		//Bokor
		manager.load(BOKOR_EP_TEXTURE);
		manager.load(BOKOR_LAPOS_TEXTURE);

		//Logó
		manager.load(LOGO1_TEXTURE);
		manager.load(LOGO2_TEXTURE);
		manager.load(LOGO3_TEXTURE);

		//Táblák
		manager.load(BAK_15_TEXTURE);
		manager.load(BAK_35_TEXTURE);
		manager.load(KESZTHELY_TEXTURE);
		manager.load(LENTI_40_TEXTURE);
		manager.load(LETENYE_35_TEXTURE);
		manager.load(NAGYKANIZSA_40_TEXTURE);


		//Zene
		manager.load(Miami_Soul);
	}

    public static void afterLoaded() {
        manager.get(Miami_Soul).setLooping(true);
    }

	public static void unload() {
		manager.dispose();
	}

}
