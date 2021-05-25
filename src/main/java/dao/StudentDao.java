package dao;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * @ProjectName: Time_On_Internet
 * @Package: dao
 * @ClassName: StudentDao
 * @Author: 82042
 * @Description: scan from students_table
 * @Date: 2021/4/25 8:54
 * @Version: 1.0
 */
public class StudentDao {
    public static HashMap<String,Integer> scanTable(String tableName) throws IOException {
        HashMap<String,Integer> stuMap = new HashMap<>(4);
        System.out.println("被调用了!");
        Configuration configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum","node01,node02,node03");
        configuration.set("hbase.zookeeper.property.clientPort","2181");
        configuration.addResource(new File("hbase-site.xml").toURI().toURL());
        configuration.addResource(new File("core-site.xml").toURI().toURL());
        System.out.println(configuration);
        Connection connection = ConnectionFactory.createConnection(configuration);
        System.out.println(connection);
        Admin admin = connection.getAdmin();
        TableName tableName1 = TableName.valueOf(tableName);
        Table table = connection.getTable(tableName1);
        Scan scan = new Scan();
        ResultScanner resultS = table.getScanner(scan);
        for (Result result : resultS) {
            for (Cell cell : result.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneRow(cell))+"::"+Integer.parseInt(Bytes.toString(CellUtil.cloneValue(cell))));
                stuMap.put(Bytes.toString(CellUtil.cloneRow(cell)),Integer.parseInt(Bytes.toString(CellUtil.cloneValue(cell))));
            }
        }
        //4、关闭连接
        admin.close();
        table.close();
        connection.close();
        //5、返回结果
        return stuMap;
    }
}
