package collision;

import entitity.Player;
import main.others.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class CollisionManager {
    private final static int playerSize = new GamePanel().tileSize;

    public static boolean isColliding(Player player, ArrayList<Rectangle> collidingArea) {
        int playerDimension = new GamePanel().tileSize;
        Rectangle playerRect = new Rectangle(player.x, player.y, playerDimension / 2, playerDimension / 2);
        for (Rectangle rectangle : collidingArea) {
            if (rectangle.intersects(playerRect)) {
                return true;
            }
        }
        return false;
    }

//TODO learn and implement a better mechanism
    public static void reAlign(Player player, ArrayList<Rectangle> collidingArea) {
		for (Rectangle rect : collidingArea) {
			int rectLeft = rect.x;
			int rectRight = rect.x + rect.width;
			int rectTop = rect.y;
			int rectBottom = rect.y + rect.height;

			int playerLeft = player.x;
			int playerRight = player.x + playerSize;
			int playerTop = player.y;
			int playerBottom = player.y + playerSize;

			// Check AABB overlap first
			boolean isOverlapping = playerRight > rectLeft && playerLeft < rectRight &&
					playerBottom > rectTop && playerTop < rectBottom;
			if (!isOverlapping) {
				continue;
			}

			// Compute overlaps on each side
			int overlapLeft = playerRight - rectLeft;      // overlap if coming from left
			int overlapRight = rectRight - playerLeft;     // overlap if coming from right
			int overlapTop = playerBottom - rectTop;       // overlap if coming from top
			int overlapBottom = rectBottom - playerTop;    // overlap if coming from bottom

			int minOverlapX = Math.min(overlapLeft, overlapRight);
			int minOverlapY = Math.min(overlapTop, overlapBottom);

			// Resolve using the minimum translation vector (MTV)
			if (minOverlapX < minOverlapY) {
				// Resolve horizontally
				if (overlapLeft < overlapRight) {
					// Push player left
					player.x -= overlapLeft;
				} else {
					// Push player right
					player.x += overlapRight;
				}
			} else {
				// Resolve vertically
				if (overlapTop < overlapBottom) {
					// Push player up
					player.y -= overlapTop + 10;
				} else {
					// Push player down
					player.y += overlapBottom;
				}
			}
		}
	}

}
