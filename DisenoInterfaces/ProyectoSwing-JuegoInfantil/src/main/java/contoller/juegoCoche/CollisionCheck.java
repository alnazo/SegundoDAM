package contoller.juegoCoche;

import view.juegoCoche.CarGame;

public class CollisionCheck {

    CarGame cg;

    public CollisionCheck(CarGame cg){
        this.cg = cg;
    }

    public void check(Entity entity){
        int left = entity.x + entity.solidArea.x;
        int right = entity.x + entity.solidArea.x + entity.solidArea.width;
        int front = entity.y + entity.solidArea.y;
        int back = entity.y + entity.solidArea.y + entity.solidArea.height;

        int leftColc1 = cg.c1.x + cg.c1.solidArea.x;
        int rightColc1 = cg.c1.x + cg.c1.solidArea.x + cg.c1.solidArea.width;
        int backColc1 =  cg.c1.y + cg.c1.solidArea.y;
        int frontColc1 =  cg.c1.y + cg.c1.solidArea.y + cg.c1.solidArea.height;

        int leftColc2 = cg.c2.x + cg.c2.solidArea.x;
        int rightColc2 = cg.c2.x + cg.c2.solidArea.x + cg.c2.solidArea.width;
        int backColc2 = cg.c2.y + cg.c2.solidArea.y;
        int frontColc2 = cg.c2.y + cg.c2.solidArea.y + cg.c2.solidArea.height;

        boolean fChoqueC1 = front <= frontColc1;
        boolean bChoqueC1 = back >=backColc1;
        boolean rChoqueC1 = right >= leftColc1;
        boolean lChoqueC1 = left <= rightColc1;

        boolean fChoqueC2 = front <= frontColc2;
        boolean bChoqueC2 = back >= backColc2;
        boolean rChoqueC2 = right >= leftColc2;
        boolean lChoqueC2 = left <= rightColc2;

        boolean colisionC1 = fChoqueC1 && bChoqueC1 && rChoqueC1 && lChoqueC1;
        boolean colisionC2 = fChoqueC2 && bChoqueC2 && rChoqueC2 && lChoqueC2;

        if ((colisionC1 && cg.c1.active) || (colisionC2  && cg.c2.active)){
            cg.stopMusic();
            cg.playSE(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){}
            cg.endGame();
        }

    }

}
