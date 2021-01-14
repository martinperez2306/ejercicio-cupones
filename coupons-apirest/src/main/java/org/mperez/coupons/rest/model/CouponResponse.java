package org.mperez.coupons.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CouponResponse
 */
@Validated
public class CouponResponse   {
  @JsonProperty("item_ids")
  private List<String> itemIds = null;

  @JsonProperty("total")
  private Integer total = null;

  public CouponResponse itemIds(List<String> itemIds) {
    this.itemIds = itemIds;
    return this;
  }

  public CouponResponse addItemIdsItem(String itemIdsItem) {
    if (this.itemIds == null) {
      this.itemIds = new ArrayList<String>();
    }
    this.itemIds.add(itemIdsItem);
    return this;
  }

  /**
   * Get itemIds
   * @return itemIds
  **/
  @ApiModelProperty(value = "")
  
    public List<String> getItemIds() {
    return itemIds;
  }

  public void setItemIds(List<String> itemIds) {
    this.itemIds = itemIds;
  }

  public CouponResponse total(Integer total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(value = "")
  
    public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponResponse couponResponse = (CouponResponse) o;
    return Objects.equals(this.itemIds, couponResponse.itemIds) &&
        Objects.equals(this.total, couponResponse.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemIds, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponResponse {\n");
    
    sb.append("    itemIds: ").append(toIndentedString(itemIds)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
