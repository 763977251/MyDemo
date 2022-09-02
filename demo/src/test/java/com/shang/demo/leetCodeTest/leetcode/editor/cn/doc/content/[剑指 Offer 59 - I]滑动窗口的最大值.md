<p>给定一个数组 <code>nums</code> 和滑动窗口的大小 <code>k</code>，请找出所有滑动窗口里的最大值。</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> <em>nums</em> = <span><code>[1,3,-1,-3,5,3,6,7]</code></span>, 和 <em>k</em> = 3
<strong>输出: </strong><span><code>[3,3,5,5,6,7] 
<strong>解释: 
</strong></code></span>
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<p>你可以假设 <em>k </em>总是有效的，在输入数组&nbsp;<strong>不为空&nbsp;</strong>的情况下，<code>1 ≤ k ≤&nbsp;nums.length</code>。</p>

<p>注意：本题与主站 239 题相同：<a href="https://leetcode-cn.com/problems/sliding-window-maximum/">https://leetcode-cn.com/problems/sliding-window-maximum/</a></p>

<div><div>Related Topics</div><div><li>队列</li><li>滑动窗口</li><li>单调队列</li><li>堆（优先队列）</li></div></div><br><div><li>👍 485</li><li>👎 0</li></div>