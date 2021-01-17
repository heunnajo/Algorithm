package graph;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		int course = 4;
		int[][] nums = { { 1, 0 }, { 2, 1 }, { 3, 2 } };

		int[][] nums2 = { { 1, 0 }, { 0, 1 } };

//		int[][] nums2 = { 
//				 { 1, 2 }, 
//		         { 3, 1 },
//		         { 2, 3 } };

		CourseSchedule a = new CourseSchedule();
		System.out.println(a.canFinish(course, nums));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 0.예외 제외
		if (numCourses <= 0)
			return false;
		// 1.담을 그릇 생성
		int[] inDegree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		int inDegreeLength = inDegree.length;
		int prerequisitesLength = prerequisites.length;
		// 2.inDegree 셋팅.
		for (int i = 0; i < prerequisitesLength; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		// 3.큐에 0인 과목을 넣는다.
		for (int i = 0; i < inDegreeLength; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		// 4.queue 반복문
		while (!queue.isEmpty()) {
			int course = queue.poll();// 3
			// prerequisites에서 찾는다.
			for (int i = 0; i < prerequisitesLength; i++) {
				if (course == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0) {
						queue.offer(prerequisites[i][1]);
					}
				}
			}
		}
		for (int i = 0; i < inDegreeLength; i++) {
			if (inDegree[i] != 0)
				return false;
		}
		return true;
	}

}
