<p>请实现一个函数用来匹配包含<code>'. '</code>和<code>'*'</code>的正则表达式。模式中的字符<code>'.'</code>表示任意一个字符，而<code>'*'</code>表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串<code>"aaa"</code>与模式<code>"a.a"</code>和<code>"ab*ac*a"</code>匹配，但与<code>"aa.a"</code>和<code>"ab*a"</code>均不匹配。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong>
s = "aa"
p = "a"
<strong>输出:</strong> false
<strong>解释:</strong> "a" 无法匹配 "aa" 整个字符串。
</pre>

<p><strong>示例 2:</strong></p>

<pre><strong>输入:</strong>
s = "aa"
p = "a*"
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
</pre>

<p><strong>示例&nbsp;3:</strong></p>

<pre><strong>输入:</strong>
s = "ab"
p = ".*"
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
</pre>

<p><strong>示例 4:</strong></p>

<pre><strong>输入:</strong>
s = "aab"
p = "c*a*b"
<strong>输出:</strong> true
<strong>解释:</strong>&nbsp;因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
</pre>

<p><strong>示例 5:</strong></p>

<pre><strong>输入:</strong>
s = "mississippi"
p = "mis*is*p*."
<strong>输出:</strong> false</pre>

<ul> 
 <li><code>s</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母。</li> 
 <li><code>p</code>&nbsp;可能为空，且只包含从&nbsp;<code>a-z</code>&nbsp;的小写字母以及字符&nbsp;<code>.</code>&nbsp;和&nbsp;<code>*</code>，无连续的 <code>'*'</code>。</li> 
</ul>

<p>注意：本题与主站 10&nbsp;题相同：<a href="https://leetcode-cn.com/problems/regular-expression-matching/">https://leetcode-cn.com/problems/regular-expression-matching/</a></p>

<div><div>Related Topics</div><div><li>递归</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 438</li><li>👎 0</li></div>