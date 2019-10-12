package Leetcode

/**
  * Created by lyk on 2019-10-12.
  * Package name: Leetcode
  * Porject name: LearnScala
  */
class ImplementTrie {
  /** Initialize your data structure here. */
  val root = new Node(new Array[Node](26), false)

  /** Inserts a word into the trie. */
  def insert(word: String) {
    var ptr = root
    for (ch <- word) {
      if (ptr.children(ch - 'a') == null) ptr.children(ch - 'a') = new Node(new Array[Node](26), false)
      ptr = ptr.children(ch - 'a')
    }
    ptr.isWordEnd = true
  }

  /** Returns if the word is in the trie. */
  def search(word: String): Boolean = {
    val ptr = searchUtil(word)
    if (ptr == null) false else ptr.isWordEnd
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith(prefix: String): Boolean = {
    searchUtil(prefix) != null
  }

  def searchUtil(word: String): Node = {
    var ptr = root
    for (ch <- word) {
      if (ptr.children(ch - 'a') == null) return null
      ptr = ptr.children(ch - 'a')
    }
    ptr
  }

  class Node(val children: Array[Node], var isWordEnd: Boolean)
}
object ImplementTrie {
  def main(args: Array[String]) {
    val a = new ImplementTrie
    a.insert("apple")
    println(a.search("apple"))
    println(a.search("app"))
    println(a.startsWith("app"))
  }
}
