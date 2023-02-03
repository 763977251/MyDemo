<p>给定一种规律 <code>pattern</code>&nbsp;和一个字符串&nbsp;<code>s</code>&nbsp;，判断 <code>s</code>&nbsp;是否遵循相同的规律。</p>

<p>这里的&nbsp;<strong>遵循&nbsp;</strong>指完全匹配，例如，&nbsp;<code>pattern</code>&nbsp;里的每个字母和字符串&nbsp;<code>s</code><strong>&nbsp;</strong>中的每个非空单词之间存在着双向连接的对应规律。</p>

<p>&nbsp;</p>

<p><strong>示例1:</strong></p>

<pre>
<strong>输入:</strong> pattern = <span><code>"abba"</code></span>, s = <span><code>"dog cat cat dog"</code></span>
<strong>输出:</strong> true</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong>pattern = <span><code>"abba"</code></span>, s = <span><code>"dog cat cat fish"</code></span>
<strong>输出:</strong> false</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> pattern = <span><code>"aaaa"</code></span>, s = <span><code>"dog cat cat dog"</code></span>
<strong>输出:</strong> false</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;= pattern.length &lt;= 300</code></li> 
 <li><code>pattern</code>&nbsp;只包含小写英文字母</li> 
 <li><code>1 &lt;= s.length &lt;= 3000</code></li> 
 <li><code>s</code>&nbsp;只包含小写英文字母和&nbsp;<code>' '</code></li> 
 <li><code>s</code>&nbsp;<strong>不包含</strong> 任何前导或尾随对空格</li> 
 <li><code>s</code>&nbsp;中每个单词都被 <strong>单个空格 </strong>分隔</li> 
</ul>

<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li></div></div><br><div><li>👍 496</li><li>👎 0</li></div>