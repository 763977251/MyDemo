<p>给定一个数组 <code>A[0,1,…,n-1]</code>，请构建一个数组 <code>B[0,1,…,n-1]</code>，其中&nbsp;<code>B[i]</code> 的值是数组 <code>A</code> 中除了下标 <code>i</code> 以外的元素的积, 即&nbsp;<code>B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]</code>。不能使用除法。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre>
<strong>输入:</strong> [1,2,3,4,5]
<strong>输出:</strong> [120,60,40,30,24]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>所有元素乘积之和不会溢出 32 位整数</li> 
 <li><code>a.length &lt;= 100000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 329</li><li>👎 0</li></div>