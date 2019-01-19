import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import java.util.Random;

public class mainGame extends Game
{ private SpriteBatch batch;
  private Texture charTexture;
  private float charX;
  private float charY;
  private Rectangle charRectangle;
  private float floorX;
  private float floorY;
  private float floorW;
  private float floorH;
  private Rectangle floorRectangle;
  private Texture forestTexture;
  private float gravity;
  private boolean gate;
  private float forestX;
  private float forestY;
  private float movementSpeed;
  private int frameCounter;
  private boolean walkingCheck;
  private Rectangle wallRectangle;
  private float wallX;
  private float wallY;
  private Texture powerupTexture;
  private float powerupX;
  private float powerupY;
  private Texture powerupusedTexture;
  private float powerupusedX;
  private float powerupusedY;
  private Rectangle powerupRectangle;
  private ShapeType charHittype;
  private ShapeRenderer charHitbox;
  private float powerupCounter;
  private boolean powerupCheck;
  private Rectangle [] platRect=new Rectangle[20];
  private float [] platX=new float[20];
  private float [] platY=new float[20];
  private Rectangle [] coin=new Rectangle[20];
  private float [] coinX=new float[20];
  private float [] coinY=new float[20];
  private float coinW;
  private float coinH;
  private float platW;
  private float platH;
  private Rectangle powerupBarRect;
  private float powerupBarX;
  private float powerupBarY;
  private float powerupBarW;
  private float powerupBarH;
  private boolean typePullGateD;
  private boolean typePullGateW;
  private boolean typePullGateS;
  private boolean typePullGateA;
private Music bgmusic;
private Music endmusic;
  private float hookVelocity;
  private ShapeType shapeType;
  private ShapeRenderer shapeRenderer;
  private Texture hookTexture;
  private Rectangle hookRectangle;
  private float hookX;
  private float hookY;
  private float hookW;
  private float hookH;
  private float addativeHookVelocity;
  private boolean hookShot;
  private boolean pullGate;
  private float camX;
  private float camY;
  private Rectangle wallW;
  private float wallWX;
  private float wallWY;
  private Rectangle wallE;
  private float wallEX;
  private float wallEY;
  private boolean stillCameraGate;
  private int intialisingCounter;
  private boolean jumpGate;
  private boolean right;
  private int g;
  private boolean tooFarRight;
  private boolean tooFarLeft;
  private boolean movementScreen;
  private boolean start;
  private Texture menuTexture;
  private TextureRegion menuTextureRegion;
  private Texture endMenuTexture;
  private TextureRegion endMenuTextureRegion;
  private int clock;
  private int score;
  private String points;
  private int timer;
  private String seconds;
  private int randomNum;
  private boolean winCondition;
  BitmapFont yourBitmapFontName;
  Random rand;
  private boolean door;
  private boolean noRight;
   public void menu(){
     if(start==false){
       batch.begin();
       batch.draw(menuTextureRegion,0,0);
       batch.end();
     }
     if (Gdx.input.isKeyPressed(Keys.ENTER)){
       start = true;
     }
   }

  public void create() {
    endmusic = Gdx.audio.newMusic(Gdx.files.internal("assets/end.mp3"));
    bgmusic = Gdx.audio.newMusic(Gdx.files.internal("assets/bg.mp3"));
    noRight=false;
door=false;
    winCondition=false;
    clock=0;
    yourBitmapFontName = new BitmapFont();
    score = 0;
    timer = 0;
    seconds = "0 seconds";
    movementScreen=false;
    tooFarRight=false;
    tooFarLeft=false;
    powerupCheck = false;
    gate=true;
    batch = new SpriteBatch();
    camX=0;
    camY=200;
    floorW = 1000;
    floorH = 300;
    movementSpeed=3;
    forestTexture = new Texture(Gdx.files.internal("assets/forest3.jpg") );
    forestX=0;
    forestY=0;
    jumpGate=false;
    charTexture = new Texture( Gdx.files.internal("assets/protag.png") );
    charX=250;
    
    charY = 200;
    charRectangle = new Rectangle(charX, charY, charTexture.getWidth(), charTexture.getHeight());
    powerupTexture = new Texture(Gdx.files.internal("assets/powerup.png") );
    powerupX = 250;
    powerupY = floorY+30;
    powerupRectangle = new Rectangle(powerupX, powerupY, powerupTexture.getWidth(), powerupTexture.getHeight());
    powerupusedTexture = new Texture(Gdx.files.internal("assets/powerup2.png") );
    powerupusedX = 250;
    powerupusedY = -500;
    frameCounter=0;
    right=true;
    walkingCheck=false;
    intialisingCounter=1;
    platX[0]=0;
    platY[0]=300;
    
    
    platX[1]=platX[0]+250;
    platY[1]=platY[0]+100;
    platX[2]=platX[0]+350;
    platY[2]=platY[0]+200;
    platX[3]=platX[0]+425;
    platY[3]=platY[0]+300;
    platX[4]=platX[0]+500;
    platY[4]=platY[0]+300;
    platX[5]=platX[0]+575;
    platY[5]=platY[0]+200;
    platX[6]=platX[0]+650;
    platY[6]=platY[0]+100;
    platX[7]=platX[0]+350;
    platY[7]=platY[0]+600;
    platX[8]=platX[0]+575;
    platY[8]=platY[0]+600;
    platX[9]=platX[0]+425;
    platY[9]=platY[0]+800;
    platX[10]=platX[0]+500;
    platY[10]=platY[0]+800;
    
    
    
    platW = 75;
    platH = 20;
    platRect[0] = new Rectangle(platX[0], platY[0], floorW, platH);
    for (int i =1; i<20;i++){
      platRect[i] = new Rectangle(platX[i], platY[i], platW, platH);
    }
    powerupBarX = forestX+30;
    powerupBarY = -1000;
    powerupBarW = 500;
    powerupBarH = 30;
    powerupBarRect = new Rectangle(powerupBarX, powerupBarY, powerupBarW, powerupBarH);
    hookW=10;
    hookH=10;
    hookRectangle=new Rectangle (hookX,hookY,hookW,hookH);
    stillCameraGate = false;
    shapeRenderer=new ShapeRenderer();
    hookVelocity=10;
    menuTexture = new Texture (Gdx.files.internal("assets/loadingscreenEDIT3.png"));
    menuTextureRegion = new TextureRegion(menuTexture);
    endMenuTexture = new Texture (Gdx.files.internal("assets/YouWin.png"));
    endMenuTextureRegion = new TextureRegion(endMenuTexture);
    for (int y=0;y<6;y++){
    coinX[y]=platX[y+1]+37;
    coinY[y]=platY[y+1]+800;
  }
    coinW=10;
    coinH=15;
    for (int u=0;u<6;u++){
      coin[u]= new Rectangle (coinX[u],coinY[u],coinW,coinH);
    }
    
    
    pullGate=false;
    typePullGateD=false;
    typePullGateD=false;
    typePullGateW=false;
    typePullGateA=false;
    wallWX = 200;
    wallWY = 75;
    wallEX = 750;
    wallEY = 75;
    wallW = new Rectangle (wallWX,wallWY,20,1000);
    wallE = new Rectangle (wallEX,wallEY,20,1000);
  }
  public void floor(int numType){
    if (charRectangle.overlaps(platRect[numType])&&charX>platY[numType]+20) {
      gravity=0;
      camY-=charY-(platY[numType]+platH-1);
      gate = false;
    }
    return;
  }
   public void bottomFloor(int numType){
    if (charRectangle.overlaps(platRect[numType])&&charX<platY[numType]+20) {
      
      camY+=charY-(platY[numType]);
      
    }
    return;
  }

  

    
  public void render(){
          bgmusic.play();
    menu();
  if (start==true) {
    clock++;

    if (clock==60){
    
    timer++;
    clock=0;
    }
     seconds = timer+" seconds";
     points = score+" points";
     
     for (int e=0; e<6;e++){
     if (charRectangle.overlaps(coin[e])) {
       coinY[e]=700;
       score++;
     }
     else{coinY[e]-=2;}
     }
     for (int e=0; e<6;e++){
     if (coinY[e]<=-60) {
       coinY[e]=700;
     }
     else{coinY[e]-=2; }
     }
     
    if (addativeHookVelocity==800){
      hookShot=false;
      addativeHookVelocity=0;
    }
    /*-------------------------------------------------walking---------------------------------------------------------*/
    if (frameCounter<=8&&walkingCheck&&!pullGate){
      if (right){
        charTexture =   new Texture( Gdx.files.internal("assets/protag.png") );
      }
      if (right==false){
        charTexture = new Texture (Gdx.files.internal("assets/protag2.png"));
      }
      frameCounter++;
    }
    if (frameCounter>=8&&frameCounter<=16&&walkingCheck){
      if (right){
        charTexture = new Texture( Gdx.files.internal("assets/protagRun.png") ); 
      }
      if (right==false){
        charTexture = new Texture (Gdx.files.internal("assets/protagRun2.png"));
      }
      
      frameCounter++;
    }
    if (frameCounter==16&&walkingCheck){
      frameCounter=0;
    }
    walkingCheck=false;
    /*-------------------------------------------floor-------------------------------------------------------------*/
    gate=true;
    for(int o = 0; o<11;o++){
      floor(o);
    }
    for(int o = 0; o<11;o++){
      bottomFloor(o);
    }
    
    if (gate&&pullGate==false){
      camY += gravity;
      gravity +=-1;
    }
    
    
    
    /*-----------------------------------------------left and right inputs---------------------------------------------------------*/
     if (!winCondition&&wallEX<325){
      camX=0;
      noRight=true;
    }
     else{noRight=false;}
    if (Gdx.input.isKeyPressed(Keys.LEFT)&&!pullGate){
      
      walkingCheck=true;
      right=false;
      camX+=movementSpeed;
      
    }
     if (forestX>-10){
      camX=0;
    }
    
    
    if (Gdx.input.isKeyPressed(Keys.RIGHT)&&!pullGate&&!noRight||winCondition){
      walkingCheck=true;
      right=true;
      camX-=movementSpeed;
    }
    
    if (Gdx.input.isKeyPressed(Keys.UP)&&gate==false&&!pullGate){
      gravity=15;
      camY+=gravity;
    }
    /*------------------------------------------grappling inputs---------------------------------------------------------*/
    if (Gdx.input.isKeyPressed(Keys.D)&&pullGate==false){
      hookY=charY+10;
      hookX=charX;
      hookX+=hookVelocity;
      hookShot=true;
      typePullGateD=true;
    }
    
    
    else if (Gdx.input.isKeyPressed(Keys.W)&&pullGate==false){
      hookX=charX+10;
      hookY=charY;
      hookY+=hookVelocity;
      hookShot=true;
      typePullGateW=true;
    }
    else if (Gdx.input.isKeyPressed(Keys.A)&&pullGate==false){
      hookX=charX+10;
      hookY=charY;
      hookY+=hookVelocity;
      hookShot=true;
      typePullGateA=true;
    }
    else {
      hookShot=false;
      addativeHookVelocity=0;
    }
    if(hookShot&&pullGate==false&&typePullGateD){
      addativeHookVelocity+=hookVelocity;
      hookX+=addativeHookVelocity;        
    }
    else if(hookShot&&pullGate==false&&typePullGateW){
      addativeHookVelocity+=hookVelocity;
      hookY+=addativeHookVelocity; 
      
      
    }
    else if(hookShot&&pullGate==false&&typePullGateA){
      addativeHookVelocity+=hookVelocity;
      hookX-=addativeHookVelocity;
    }
    else if (hookShot==false&&pullGate==false){

      typePullGateD=false;
      typePullGateW=false;
      typePullGateA=false;
      hookX=charX;
      hookY=charY+10;
      
    }
    /*----------------------------------grappling pull----------------------------------------------------------*/

    


    if (hookRectangle.overlaps(platRect[1])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[2])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[3])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[4])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[5])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[6])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[7])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[8])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[9])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(platRect[10])&&Math.abs(charY-hookY)>40){
      pullGate=true;
      hookShot=false;
      if (charY<hookY){
        hookY-=hookVelocity;
        camY=hookVelocity;
      }      
    }
    else if (hookRectangle.overlaps(wallW)&&Math.abs(charX-hookX)>40){
 
      pullGate=true;
      hookShot=false;
      
      
      if (charX>hookX){
        hookX+=hookVelocity;
        camX=hookVelocity;    
      }
      
    }
    else if (hookRectangle.overlaps(wallE)&&Math.abs(charX-hookX)>40){
 
      pullGate=true;
      hookShot=false;
      
      
     if (charX<hookX){
        hookX-=hookVelocity;
        camX=-hookVelocity;
        
      }
      
    }
    
    else {
      pullGate=false;
      
    }
   
    
    /*--------------------------------------movementX----------------------------------------------------*/
    wallWX +=camX;
    wallEX+=camX;
    powerupX+=camX;
    forestX+=camX;
    powerupusedX+=camX;
    floorX+=camX;
    
    for (int p=0;p<11;p++){
      platX[p]+=camX;
    }
   for (int p=0;p<7;p++){
      coinX[p]+=camX;
    }
    /*--------------------------------------movementY----------------------------------------------------*/
    powerupY-=camY;
    wallWY-= camY;
   
    wallEY -= camY;
    forestY-=camY;
    floorY-=camY;
    powerupusedY-=camY;
    
    for (int p=0;p<11;p++){
      platY[p]-=camY;
    }
  for (int p=0;p<6;p++){
      coinY[p]-=camY;
    }
    camX=0;
    camY=0;
    
    if (score>=5){
     winCondition=true;
    }
    /*-----------------------------compiler-------------------------------------------------------------------------------------------*/    
    
    
    // clear screen and draw graphics
    Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    
    
    batch.draw( forestTexture, forestX, forestY );
    charRectangle = new Rectangle(charX, charY, charTexture.getWidth()-15, charTexture.getHeight());
    batch.draw( charTexture, charX, charY);
    powerupRectangle = new Rectangle(powerupX, powerupY, powerupTexture.getWidth(), powerupTexture.getHeight());
    platRect[0] = new Rectangle(platX[0], platY[0], floorW, platH);
    for (int w=1;w<11;w++){
      platRect[w] = new Rectangle(platX[w], platY[w], platW, platH);
    }
    for (int u=0;u<6;u++){
      coin[u]= new Rectangle (coinX[u],coinY[u],coinW,coinH);
    }
    powerupBarRect = new Rectangle(powerupBarX, powerupBarY, powerupBarW, powerupBarH);
    wallW = new Rectangle (wallWX,wallWY,50,1000);
    if (!winCondition){
    wallE = new Rectangle (wallEX,wallEY,50,1000);
    }
    hookRectangle= new Rectangle (hookX,hookY,hookW,hookH);
    batch.draw( charTexture, charX, charY );
    batch.draw( powerupTexture, powerupX, powerupY );
    batch.draw( powerupusedTexture, powerupusedX, powerupusedY );
    yourBitmapFontName.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    yourBitmapFontName.draw(batch, seconds, 25, 550); 
    yourBitmapFontName.draw(batch, points, 25, 575); 
    batch.end();
    
    
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(1, 0, 1, 1);
    shapeRenderer.circle(hookX, hookY, hookW);
    shapeRenderer.end();
    
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(1, 0, 1, 0);
    for (int x=1;x<11;x++){
      shapeRenderer.rect(platX[x], platY[x], platW, platH);
    }
    shapeRenderer.end();
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(1, 1, 0, 1);
    shapeRenderer.rect(floorX,floorY,floorW,floorH);
      shapeRenderer.rect(platX[0], platY[0], floorW, platH);
    shapeRenderer.end();
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(1,0,0,1);
    shapeRenderer.rect(wallWX, wallWY, 20, 1000);
    if (!winCondition){
    shapeRenderer.rect(wallEX, wallEY, 20, 1000);
    }
    shapeRenderer.rect(powerupBarX, powerupBarY, powerupBarW, powerupBarH);
    shapeRenderer.end();
      
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(0, 1, 0, 1);    
    shapeRenderer.circle(hookX, hookY, hookW);
    shapeRenderer.end();
    
    shapeRenderer.begin(ShapeType.Filled);
    shapeRenderer.setColor(1, 1, 0, 1);
    for (int u=0;u<6;u++){
      shapeRenderer.circle(coinX[u],coinY[u],coinW);
    }
    shapeRenderer.end();
    shapeRenderer.begin(ShapeType.Line);
    shapeRenderer.setColor(0, 0, 1, 1);
    shapeRenderer.line(charX+charTexture.getWidth(), charY+10,hookX,hookY );
    shapeRenderer.end();
    if (winCondition){
      batch.begin();
      batch.draw(endMenuTextureRegion,0,0);
      batch.end();
      endmusic.play();
    }
  }
  }
}