import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mvc.dao.TrHeaderPenjualanDao;
import com.mvc.dto.MstKaryawanDto;
import com.mvc.dto.TrHeaderPenjualanDto;
import com.mvc.entity.TrHeaderPenjualan;
import com.mvc.service.LoginSvc;
import com.mvc.service.TransaksiSvc;

public class test {

	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		LoginSvc cekLogin = ctx.getBean(LoginSvc.class);
//		TransaksiSvc tr = ctx.getBean(TransaksiSvc.class);
		
		MstKaryawanDto dtodata = cekLogin.login("jayskak");
		System.out.println(dtodata.getKodeKaryawan());
		
//		List<TrHeaderPenjualanDto> list = tr.listTransaksiHeader();
//		
//		for (TrHeaderPenjualanDto a : list) {
//			System.out.println(a.getHargaTotal());
//		}
		
		
	}

}
