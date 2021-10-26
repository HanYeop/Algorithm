import java.util.*

// 노드 데이터 클래스
data class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

// String 트리 클래스
class Tree{
    var root : TreeNode<String>? = null

    // 트리 추가
    fun add(data: String, left: String, right: String){
        // 루트가 NULL 일 때 (트리 내에 존재하지 않을 때)
        if(root == null){
            // 새로 생성
            if(data != ".") root = TreeNode(data)
            if(left != ".") root!!.left = TreeNode(left)
            if(right != ".") root!!.right = TreeNode(right)
        }
        // 트리 내에 존재할 때
        else search(root!!,data,left,right)
    }

    private fun search(root: TreeNode<String>, data: String, left: String, right: String){
        // 찾았을 때, left right 연결
        if(root.data == data){
            if(left != ".") root!!.left = TreeNode(left)
            if(right != ".") root!!.right = TreeNode(right)
        }

        // 못 찾았을 때, 좌우 탐색
        else {
            if(root.left != null) search(root.left!!,data,left,right)
            if(root.right != null) search(root.right!!,data,left,right)
        }
    }

    // 전위 순회 (루트, 왼쪽 자식, 오른쪽 자식)
    fun preOrder(root: TreeNode<String>){
        print(root.data)
        if(root.left != null) preOrder(root.left!!)
        if(root.right != null) preOrder(root.right!!)
    }

    // 중위 순회 (왼쪽 자식, 루트, 오른쪽 자식)
    fun inOrder(root: TreeNode<String>){
        if(root.left != null) inOrder(root.left!!)
        print(root.data)
        if(root.right != null) inOrder(root.right!!)
    }

    // 후위 순회 (왼쪽 자식, 오른쪽 자식, 루트)
    fun postOrder(root: TreeNode<String>){
        if(root.left != null) postOrder(root.left!!)
        if(root.right != null) postOrder(root.right!!)
        print(root.data)
    }
}

fun main() = with(Scanner(System.`in`)) {
    val n = nextLine().toInt()
    val tree = Tree()

    // 트리 만들기
    for(i in 0 until n){
        val (a,b,c) = nextLine().split(" ")
        tree.add(a,b,c)
    }

    tree.preOrder(tree.root!!)
    println()
    tree.inOrder(tree.root!!)
    println()
    tree.postOrder(tree.root!!)
}

