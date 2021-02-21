package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate iiii) {
        selectedPoints.add(iiii);
    }

    public void unselect(Coordinate iiii) {
        selectedPoints.remove(iiii);
    }

    public boolean isSelected(Coordinate iiii) {
        return selectedPoints.contains(iiii);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate iiii) {
        int[][] i = new int[3][2];
        int ii = 0;
        
        for (Coordinate iii : getSelectedPoints()) {
            i[ii][1] = iii.getY();
            i[ii][0] = iii.getX();
            ii++;
        }

        double iiiii = (double) (iiii.getX() - i[2][0]) * (i[0][1] - i[2][1]) - (iiii.getY() - i[2][1]) * (i[0][0] - i[2][0]) < 0
        double iiiiii = (double) (iiii.getX() - i[0][0]) * (i[1][1] - i[0][1]) - (iiii.getY() - i[0][1]) * (i[1][0] - i[0][0]) < 0
        double iiiiiii = (double) (iiii.getX() - i[1][0]) * (i[2][1] - i[1][1]) - (iiii.getY() - i[1][1]) * (i[2][0] - i[1][0]) < 0

        return iiiii && iiiiii && iiiiiii;
    }
}
