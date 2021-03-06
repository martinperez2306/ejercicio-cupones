package org.mperez.coupons.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CouponRequest
 */
@Validated
public class CouponRequest   {
  @JsonProperty("item_ids")
  private List<String> itemIds = null;

  @JsonProperty("amount")
  private Float amount = null;

  public CouponRequest itemIds(List<String> itemIds) {
    this.itemIds = itemIds;
    return this;
  }

  public CouponRequest addItemIdsItem(String itemIdsItem) {
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

  public CouponRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  
    public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CouponRequest couponRequest = (CouponRequest) o;
    return Objects.equals(this.itemIds, couponRequest.itemIds) &&
        Objects.equals(this.amount, couponRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemIds, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CouponRequest {\n");
    
    sb.append("    itemIds: ").append(toIndentedString(itemIds)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
