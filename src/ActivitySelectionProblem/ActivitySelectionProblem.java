package ActivitySelectionProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-09-27
 * @Description: 活动选择问题
 */
public class ActivitySelectionProblem {
    /*
    要在一个会议室举办 n 个活动
    - 每个活动有各自的起始&终止时间
    - 找出在时间上互不冲突的活动组合，能够最充分利用会议室（举办的活动次数最多）
     */
    // 优先选择最先结束的活动

    static class Activity{
        int index;
        int start;
        int finish;

        public Activity(int index, int start, int finish) {
            this.index = index;
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "index=" + index +
                    ", start=" + start +
                    ", finish=" + finish +
                    '}';
        }

        public int getFinish() {
            return finish;
        }
    }


    public static void select(Activity[] activities, int n){
        List<Activity> result = new ArrayList<>();

        result.add(activities[0]);
        Activity prev = activities[0];

        for (int i = 1; i < n; i++) {
            Activity cur = activities[i];

            if (cur.start >= prev.finish){
                result.add(cur);
                prev = cur;
            }
        }
        System.out.printf("total amount = %d", result.size());
        System.out.println(Arrays.toString(result.toArray()));
    }


    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 2, 4),
                new Activity(0, 1, 3),
                new Activity(2,3,5)
        };
        Arrays.sort(activities, Comparator.comparingInt(Activity::getFinish));
        select(activities,activities.length);

//        System.out.println(Arrays.toString(activities));

    }

}
