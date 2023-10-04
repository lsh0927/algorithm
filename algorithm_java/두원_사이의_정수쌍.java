import java.io.*;
import java.util.*;

import static java.lang.Math.*;

class Solution {
            public long solution(int r1, int r2) {
                long answer = 0;

                // 4개의 사분면 중 1개만 구한뒤 4를 곱한다.
                for( int i = 1; i <= r2 ; i++){
                    double y2 = sqrt(pow(r2,2) - pow(i,2));
                    double y1 = sqrt(pow(r1,2) - pow(i,2));
                    answer += ( (long)y2 - (long) ceil(y1) + 1);
                }
                answer *= 4;

                return answer;
            }
        }