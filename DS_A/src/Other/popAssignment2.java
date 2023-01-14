package Other;

public class popAssignment2 {
    int max;
    LinkList l1;

    public popAssignment2(LinkList l1) {
        this.l1 = l1;
    }

    public LinkList mergeSort(LinkList l2) {
        Link curr1 = l1.head;
        Link curr2 = curr1.next;
        int min1 = (Integer) l1.head.data;

        LinkList res = new LinkList();
        Link resCurr = res.head;

        while (curr2 != null) {
            if ((Integer) curr1.data < min1) {
                min1 = (Integer) curr1.data;
                Link newLink = new Link((Integer) min1);
                resCurr = resCurr.next;
                curr1 = curr1.next;
            }
        }

        Link currl2_1 = l2.head;
        Link currl2_2 = currl2_1.next;
        int min2 = (Integer) l2.head.data;

        while (currl2_2 != null) {
            if ((Integer) currl2_1.data < min2) {
                min2 = (Integer) currl2_1.data;
                Link newLink = new Link((Integer) min2);
                resCurr = resCurr.next;
                curr1 = curr1.next;
            }
        }

        Link resCurrforHead = res.head;
        int minRes = (Integer) resCurrforHead.data;

        while (resCurrforHead.next != null) {
            if ((Integer) resCurr.data < minRes) {
                int temp = (Integer) resCurrforHead.data;
                resCurrforHead.data = (Integer) resCurrforHead.next.data;
                resCurrforHead.next.data = temp;
                resCurrforHead = resCurrforHead.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LinkList l2 = new LinkList();
        LinkList l1 = new LinkList();
        popAssignment2 idk = new popAssignment2(l1);

        idk.mergeSort(l2);
    }
}