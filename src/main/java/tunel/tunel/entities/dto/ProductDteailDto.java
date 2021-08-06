package tunel.tunel.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tunel.tunel.entities.concretes.SiteFeatures;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDteailDto {
	
	private int id;
	private String productName;

	private String technicalSpecifications;

	private String silver;

	private String gold;

	private String diamod;

	private String explanation;

	
	public static ProductDteailDto of(SiteFeatures siteFeatures) {

		return new ProductDteailDto(siteFeatures.getId(),siteFeatures.getProducts().getProductName()
				,siteFeatures.getTechnicalSpecifications(),siteFeatures.getSilver(),siteFeatures.getGold(),
				siteFeatures.getDiamod(),siteFeatures.getExplanation()
				);

	}
}
