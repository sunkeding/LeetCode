# LeetCode
## 复杂度的计算
### 时间复杂度
- 时间复杂度与代码的结构设计高度相关
- 一个顺序结构的代码，时间复杂度是 O(1)。
- 二分查找，或者更通用地说是采用分而治之的二分策略，时间复杂度都是 O(logn)。这个我们会在后续课程讲到。
- 一个简单的 for 循环，时间复杂度是 O(n)。
- 两个顺序执行的 for 循环，时间复杂度是 O(n)+O(n)=O(2n)，其实也是 O(n)。
- 两个嵌套的 for 循环，时间复杂度是 O(n²)。

### 空间复杂度
- 空间复杂度与代码中数据结构的选择高度相关
- 降低空间复杂度的核心思路：能用低复杂度的数据结构能解决问题，就千万不要用高复杂度的数据结构。
	