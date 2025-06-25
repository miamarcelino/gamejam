package io.codeforall.bootcamp.factories;


import io.codeforall.bootcamp.shootable.Target;
import io.codeforall.bootcamp.shootable.TargetType;
import io.codeforall.bootcamp.shootable.bonus.Elias;
import io.codeforall.bootcamp.shootable.enemies.Andreia;
import io.codeforall.bootcamp.shootable.enemies.Carolina;
import io.codeforall.bootcamp.shootable.enemies.Rolo;
import io.codeforall.bootcamp.shootable.pedestrians.Afonso;
import io.codeforall.bootcamp.shootable.pedestrians.Manel;
import io.codeforall.bootcamp.shootable.pedestrians.Otavio;
import io.codeforall.bootcamp.shootable.pedestrians.Tiago;

/**
 *  A factory of different types of Targets (see TargetType.java)
 *
 * @return a new instantiated target
 */
public class TargetFactory {

    public static Target getNewTarget() {

        int random = (int) (Math.random() * TargetType.values().length);
        TargetType targetType = TargetType.values()[random];

        Target target;

        switch(targetType) {
            case ANDREIA:
                target = new Andreia();
                break;

            case CAROLINA:
                target = new Carolina();
                break;

            case ROLO:
                target = new Rolo();
                break;

            case AFONSO:
                target = new Afonso();
                break;

            case MANEL:
                target = new Manel();
                break;

            case OTAVIO:
                target = new Otavio();
                break;

            case TIAGO:
                target = new Tiago();
                break;

//            case ELIAS:
//                target = new Elias();
//                break;

            default:
                target = new Rolo();
        }

        return target;
    }
}
