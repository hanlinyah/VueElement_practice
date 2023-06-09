# 說明

* 本練習係學習使用Vue學習資料雙向綁定，使用Axios組件發送異步請求實現資料庫增刪改查，並使用基於Vue的網站組件庫：Element(Plus)來美化頁面效果，本練習已內建兩組帳號密碼如下：
  * 帳號：testac01 密碼：password
  * 帳號：testac02 密碼：password
* 練習結果如下：
  * 練習首頁

    * ![1680230265753](image/readme/1680230239470.png)
  * 登入頁面(透過Filter過濾未登入之用戶)

    * ![1680230265753](image/readme/1680230265753.png)
    * ![1680230323210](image/readme/1680230323210.png)
  * 登入後進入展示頁(包含未使用Element的簡易版，及使用Element的華麗版)

    * 簡易版
      * ![1680230522416](image/readme/1680230522416.png)
      * ![1680230550281](image/readme/1680230550281.png)
    * 華麗版
      * ![1680230488876](image/readme/1680230488876.png)
      * ![1680230501210](image/readme/1680230501210.png)
  * 功能展示(以華麗版進行展示)

    * 查詢
      * 查詢所有(進入頁面或查詢條件為空點選查詢即為查詢所有)
        * ![1680230940253](image/readme/1680230929863.png)
        * ![1680230940253](image/readme/1680230940253.png)
      * 條件查詢
        * ![1680231103886](image/readme/1680231103886.png)
        * ![1680231023171](image/readme/1680231023171.png)
        * ![1680231131224](image/readme/1680231131224.png)
        * ![1680231141395](image/readme/1680231141395.png)
      * 分頁查詢(依頁面設定之每頁展示筆數及目的頁，向資料庫發送異步請求)
        * ![1680231292007](image/readme/1680231292007.png)
        * ![1680231311189](image/readme/1680231311189.png)
        * ![1680231326410](image/readme/1680231326410.png)
        * ![1680231342553](image/readme/1680231342553.png)
    * 新增(點選新增彈出填寫表單，新增完成後續依既有條件查詢)
      * ![1680231375413](image/readme/1680231375413.png)
      * ![1680231385901](image/readme/1680231385901.png)
      * ![1680231441849](image/readme/1680231441849.png)
      * ![1680232120952](image/readme/1680232120952.png)
      * ![1680232006291](image/readme/1680232006291.png)
      * ![1680232017423](image/readme/1680232017423.png)
      * ![1680232030786](image/readme/1680232030786.png)
      * ![1680232046324](image/readme/1680232046324.png)
      * ![1680232056665](image/readme/1680232056665.png)
    * 修改(點選該列修改按鈕彈出填寫表單，修改完成後續依既有條件查詢)
      * ![1680232138411](image/readme/1680232138411.png)
      * ![1680232149631](image/readme/1680232149631.png)
      * ![1680232169154](image/readme/1680232169154.png)
      * ![1680232178294](image/readme/1680232178294.png)
      * ![1680232187006](image/readme/1680232187006.png)
      * ![1680232202195](image/readme/1680232202195.png)
      * ![1680232209252](image/readme/1680232209252.png)
      * ![1680232221846](image/readme/1680232221846.png)
      * ![1680232232182](image/readme/1680232232182.png)
    * 刪除
      * 單筆刪除(點選該列刪除按鈕彈出確認提醒，點選取消則取消當前操作，點選確定則進行刪除，完成後續依既有條件查詢)
        * ![1680232328555](image/readme/1680232328555.png)
        * ![1680232341126](image/readme/1680232341126.png)
        * ![1680232362282](image/readme/1680232362282.png)
        * ![1680232371340](image/readme/1680232371340.png)
        * ![1680232381350](image/readme/1680232381350.png)
        * ![1680232394154](image/readme/1680232394154.png)
        * ![1680232406175](image/readme/1680232406175.png)
      * 批量刪除(勾選左列待刪除項，點選批量刪除按鈕彈出確認提醒，點選取消則取消當前操作，點選確定則進行刪除，完成後續依既有條件查詢)
        * ![1680232548994](image/readme/1680232548994.png)
        * ![1680232562357](image/readme/1680232562357.png)
        * ![1680232573292](image/readme/1680232573292.png)
        * ![1680232584477](image/readme/1680232584477.png)
        * ![1680232594206](image/readme/1680232594206.png)
        * ![1680232611764](image/readme/1680232605110.png)
        * ![1680232611764](image/readme/1680232611764.png)
        * ![1680232651777](image/readme/1680232651777.png)
        * ![1680232665873](image/readme/1680232665873.png)
