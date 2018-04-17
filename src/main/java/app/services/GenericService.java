package app.services;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.models.Balise;
import app.models.Champ;
import app.models.Table;
import app.repositories.BaliseRepo;
import app.repositories.ChampRepo;

@RestController
public class GenericService {

	@Autowired
	private ChampRepo repo;
	
	@Autowired
	private BaliseRepo baliseRepo;
	
	@RequestMapping("/addtables")
	public String addTables() throws Exception{
		Workbook workbook = WorkbookFactory.create(new File("excel_file.xlsx"));
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.rowIterator();
		DataFormatter dataFormatter = new DataFormatter();
		Map<String, Set<String>> map = new HashMap<>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Cell cellTable = row.getCell(0);
			Cell cellChamp = row.getCell(1);
			String tableName = dataFormatter.formatCellValue(cellTable);
			String champName = dataFormatter.formatCellValue(cellChamp);
			if (!tableName.equals("table") && !champName.trim().equals("")) {
				if (!map.containsKey(tableName)) {
					Set<String> list = new TreeSet<>();
					list.add(champName);
					map.put(tableName, list);
				} else {
					Set<String> list = map.get(tableName);
					list.add(champName);
					map.put(tableName, list);
				}
			}
		}
		for (Entry<String, Set<String>> e : map.entrySet()) {
			Table table = new Table(e.getKey());
			for (String champ : e.getValue()) {
				Champ c = new Champ(champ);
				c.setTable(table);
				repo.save(c);
			}
		}
		return "done";
	}
	
	@RequestMapping("/balise")
	public String service() {
		Balise b = baliseRepo.getOne(1L);
		String req = "select * from table where ";
		for (int i = 0; i < b.getCriteres().size(); i++) {
			Balise balise = b.getCriteres().get(i);
			if(i == 0)
				req += balise.getNom()+" = '3' ";
			else
				req += " and "+balise.getNom()+" = '3'";
		}
		return req;
	}
}
