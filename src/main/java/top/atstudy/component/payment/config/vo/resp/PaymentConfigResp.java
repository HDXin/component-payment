package top.atstudy.component.payment.config.vo.resp;

import top.atstudy.component.base.BaseSpecFields;
import top.atstudy.component.base.util.BeanUtils;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PaymentConfig 相应参数模板
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public class PaymentConfigResp extends BaseSpecFields implements Serializable {


    private Long id;

    private String projectName;

    private String paymentType;

    private String content;

    private String appid;

    private String appsecret;

    private String mchId;

    private String notifyUrl;

    private String tradeType;

    private String paymentKey;

    private String token;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType == null ? null : tradeType.trim();
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey == null ? null : paymentKey.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }


    public static PaymentConfigResp parseSinglet(PaymentConfigDTO target) {
        PaymentConfigResp self = new PaymentConfigResp();
        return self.parse(target);
    }

    public static List<PaymentConfigResp> parseList(List<PaymentConfigDTO> targets) {
        return targets.stream().map(PaymentConfigResp::parseSinglet).collect(Collectors.toList());
    }

    public PaymentConfigResp parse(PaymentConfigDTO target) {
        if(target == null) {
            return null;
        }
        BeanUtils.copyProperties(target, this);
        return this;
    }

    public static PaymentConfigDTO convertToDTO(PaymentConfigResp resp) {
        return resp.convertToDTO();
    }

    public static List<PaymentConfigDTO> convertToDTO(List<PaymentConfigResp> resps) {
        return resps.stream().map(v -> v.convertToDTO()).collect(Collectors.toList());
    }

    public PaymentConfigDTO convertToDTO() {
        return BeanUtils.copyProperties(this, PaymentConfigDTO.class);
    }
}
