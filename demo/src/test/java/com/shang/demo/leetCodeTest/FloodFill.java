package com.shang.demo.leetCodeTest;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};


    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor){
            dfs(image,sr,sc,currColor,newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int color, int newColor){
        if (image[x][y] == color){
            image[x][y] = newColor;
            int n = image.length, m=image[0].length;
            for (int i = 0; i < 4; i++) {
                int mx = x+dx[i], my = y+dy[i];
                if (mx>=0 && mx<n && my>=0 && my<m){
                    dfs(image,mx,my,color,newColor);
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor){
            return image;
        }
        int n = image.length, m=image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor){
                    queue.offer(new int[]{mx,my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }


    @Test
    public void test(){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill2(image,1,1,2);
        System.out.println(image);
    }
}
