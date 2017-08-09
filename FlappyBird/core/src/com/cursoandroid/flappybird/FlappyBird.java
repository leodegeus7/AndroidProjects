package com.cursoandroid.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {

    private int count = 0;
    private SpriteBatch batch;  //criar animações
    private Texture[] passaro;
    private Texture fundo;

    private Texture canoBaixo;
    private Texture canoTopo;
    private Texture gameOverTexture;

    private BitmapFont fonte;

    private Circle passaroCirculo;
    private Rectangle canoTopoRectangle;
    private Rectangle canoBaixoRectangle;

    private ShapeRenderer shape;

    private int y = 600;

    private float passaroWing = 0;

    private int yNovo;


    private int tamanhoX;
    private int tamanhoY;
    private int pontuacao = 0;

    private boolean subindo;

    private int posicaoHorizontalCanos = 0;
    private float deltaTime = 0;
    private int distanciaEntreCanos = 1600;
    private int distanciaRandom = 0;
    private boolean randomGerado = false;

    private boolean gameOver = false;


    @Override
    public void create() {
        Gdx.app.log("create", "inicializado o jogo");
        tamanhoX = Gdx.graphics.getWidth();
        tamanhoY = Gdx.graphics.getHeight();
        batch = new SpriteBatch();
        shape = new ShapeRenderer();

        passaroCirculo = new Circle();
        canoBaixoRectangle = new Rectangle();
        canoTopoRectangle = new Rectangle();

        fonte = new BitmapFont();
        fonte.setColor(Color.WHITE);
        fonte.getData().setScale(8);


        passaro = new Texture[3];
        passaro[0] = new Texture("passaro1.png");
        passaro[1] = new Texture("passaro2.png");
        passaro[2] = new Texture("passaro3.png");
        canoBaixo = new Texture("cano_baixo.png");
        canoTopo = new Texture("cano_topo.png");
        gameOverTexture = new Texture("game_over.png");
        fundo = new Texture("fundo.png");
        deltaTime = Gdx.graphics.getDeltaTime();
        posicaoHorizontalCanos = tamanhoX - canoTopo.getWidth() + 200;
    }

    @Override
    public void render() {
        super.render();
        if (!randomGerado) {
            Random random = new Random();
            distanciaRandom = random.nextInt(1600);
            randomGerado = true;
        }
        deltaTime = Gdx.graphics.getDeltaTime();
        if (!gameOver) {
            posicaoHorizontalCanos -= deltaTime * 700;
            if (posicaoHorizontalCanos <= -400) {
                posicaoHorizontalCanos = tamanhoX - canoTopo.getWidth() + 300;
                randomGerado = false;

            }

            if (posicaoHorizontalCanos < 120 && posicaoHorizontalCanos > 0) {
                pontuacao += 7;
            }
        }
        batch.begin();

        passaroWing += Gdx.graphics.getDeltaTime() * 10;
        if (passaroWing > 2) {
            passaroWing = 0;
        }

        if (Gdx.input.justTouched()) {
            subindo = true;
            if (y < tamanhoY) {
                yNovo = y + 400;
            } else {
                yNovo = tamanhoY - 10;
            }

        }
        batch.draw(fundo, 0, 0, tamanhoX, tamanhoY);
        if (!gameOver) {
            if (subindo) {
                y += 50;
            } else {
                y -= 17;
            }
            if (y > yNovo) {
                subindo = false;
            }
        } else {
            y -= 17;
            passaroWing = 0;
        }

        if (y < 15) {
            y = 5;
        }


        batch.draw(passaro[(int) passaroWing], 120, y, tamanhoX / 15 * tamanhoY / tamanhoX, tamanhoX / 15);
        Double largura = canoTopo.getWidth() * 2.7;
        Double altura = canoTopo.getHeight() * 2.7;


        batch.draw(canoBaixo, posicaoHorizontalCanos, 0 - distanciaRandom, Integer.valueOf(largura.intValue()), Integer.valueOf(altura.intValue()));

        batch.draw(canoTopo, posicaoHorizontalCanos, 0 + canoBaixo.getHeight() - distanciaRandom + distanciaEntreCanos, Integer.valueOf(largura.intValue()), Integer.valueOf(altura.intValue()));


        fonte.draw(batch, String.valueOf(pontuacao), tamanhoX / 2, tamanhoY - 400);

        if (gameOver) {


            batch.draw(gameOverTexture, tamanhoX / 2 - gameOverTexture.getWidth() / 2 - 150, tamanhoY - 650, 700, 700 * gameOverTexture.getHeight() / gameOverTexture.getWidth());

            if (Gdx.input.justTouched()) {

                gameOver = !gameOver;

                pontuacao = 0;

                subindo = true;

               posicaoHorizontalCanos = tamanhoX - canoTopo.getWidth() + 200;
             deltaTime = 0;
               distanciaEntreCanos = 1600;
       distanciaRandom = 0;
               randomGerado = false;
            }
        }

        batch.end();


        passaroCirculo.set(200 - passaro[0].getWidth() / 2, y, 60);

        canoBaixoRectangle = new Rectangle(posicaoHorizontalCanos, 0 - distanciaRandom, Integer.valueOf(largura.intValue()), Integer.valueOf(altura.intValue()));

        canoTopoRectangle = new Rectangle(posicaoHorizontalCanos, 0 + canoBaixo.getHeight() - distanciaRandom + distanciaEntreCanos, Integer.valueOf(largura.intValue()), Integer.valueOf(altura.intValue()));


//        shape.begin(ShapeRenderer.ShapeType.Filled);
//        shape.circle(passaroCirculo.x,passaroCirculo.y,passaroCirculo.radius);
//        shape.rect(canoBaixoRectangle.x,canoBaixoRectangle.y,canoBaixoRectangle.getWidth(),canoBaixoRectangle.getHeight());
//        shape.rect(canoTopoRectangle.x,canoTopoRectangle.y,canoTopoRectangle.getWidth(),canoTopoRectangle.getHeight());
//        shape.setColor(Color.RED);
//        shape.end();

        if (Intersector.overlaps(passaroCirculo, canoBaixoRectangle) || Intersector.overlaps(passaroCirculo, canoTopoRectangle)) {
            gameOver = true;

        }


    }
}
