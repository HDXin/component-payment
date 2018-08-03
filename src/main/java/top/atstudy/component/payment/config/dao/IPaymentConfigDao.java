package top.atstudy.component.payment.config.dao;

import top.atstudy.component.base.Page;
import top.atstudy.component.base.Pagination;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTO;
import top.atstudy.component.payment.config.dao.dto.PaymentConfigDTOExample;
import top.atstudy.component.payment.config.vo.req.PaymentConfigQuery;
import java.util.List;

/**
 * IPaymentConfigDao 接口类
 *
 * =========================================
 * <p>
 * Contributors :
 * Mybatis auto generator
 */
public interface IPaymentConfigDao {

    /**
     * 根据ID
     *
     * @return {@link PaymentConfigDTO}
     */
    PaymentConfigDTO getById(Long id);

    /**
     * 根据条件获得分页 Item 信息
     *
     * @param example mybatis criteria example
     * @return 具有分页功能的Page包装集合 {@link Page}, 其中囊括的Item类型 {@link PaymentConfigDTO}
     */
    Page<PaymentConfigDTO> findByExample(PaymentConfigDTOExample example, Pagination... pagination);


    /**
     * 根据条件获得 Item 信息列表
     *
     * @param example mybatis criteria example
     * @return List {@link List< PaymentConfigDTO >}
     */
    List<PaymentConfigDTO> listByExample(PaymentConfigDTOExample example);

    /**
     * 根据条件获得 singlet item 信息
     *
     * @param example mybatis criteria example
     * @return Item {@link PaymentConfigDTO}
     */
    PaymentConfigDTO getByExample(PaymentConfigDTOExample example);

    /**
     * 根据条件获得 统计数值 信息
     *
     * @param example mybatis criteria example
     * @return 统计数值
     */
    Long countByExample(PaymentConfigDTOExample example);


    /**
     * 根据自定义Query获得具备分页的 Item 列表
     *
     * @param query 自定义Query {@link PaymentConfigQuery}
     * @return 具有分页功能的Page包装集合 {@link Page}, 其中囊括的Item类型 {@link PaymentConfigDTO}
     */
    Page<PaymentConfigDTO> findByQuery(PaymentConfigQuery query);

    /**
     * 根据自定义Query获得 Item 列表
     *
     * @param query 自定义Query {@link PaymentConfigQuery}
     * @return List {@link List< PaymentConfigDTO >}
     */
    List<PaymentConfigDTO> listByQuery(PaymentConfigQuery query);

    /**
     * 根据自定义Query获得 统计数值
     *
     * @param query 自定义Query
     * @return 统计数值
     */
    Long countByQuery(PaymentConfigQuery query);

    /**
     * 创建 Item
     * *注意* 参数作为瞬时数据, 严密逻辑下, 推荐不要在之后逻辑中使用
     *
     * @param target Item {@link PaymentConfigDTO}
     * @return 操作flag
     */
    boolean create(PaymentConfigDTO target);

    /**
     * 创建并获得最新Item
     *
     * @param target Item {@link PaymentConfigDTO}
     * @return 持久数据, 可在之后的逻辑中使用. {@link PaymentConfigDTO}
     */
    PaymentConfigDTO createAndGet(PaymentConfigDTO target);

    /**
     * 更新 Item
     * *注意* 参数作为瞬时数据, 严密逻辑下, 推荐不要在之后逻辑中使用
     *
     * @param target Item {@link PaymentConfigDTO}
     * @return 操作flag
     */
    boolean update(PaymentConfigDTO target);

    /**
     * 更新 Item
     *
     * @param target Item {@link PaymentConfigDTO}
     * @return 持久数据, 可在之后的逻辑中使用. {@link PaymentConfigDTO}
     */
    PaymentConfigDTO updateAndGet(PaymentConfigDTO target);


    /**
     * 根据 Item 删除
     *
     * @param target Item {@link PaymentConfigDTO}
     * @return 操作flag
     */
    boolean remove(PaymentConfigDTO target);

    /**
     * 批量创建 Item
     *
     * @param targets List Item 组 {@link PaymentConfigDTO}
     * @return 
     * 操作flag
     * 全部成功为 true
     * 至少存在一条失败则为 false
     * 这里需要业务逻辑层做回滚, 生成的代码没有做回滚操作
     */
    boolean batchCreate(List<PaymentConfigDTO> targets);

    /**
     * 批量创建 更新
     *
     * @param targets List Item 组 {@link PaymentConfigDTO}
     * @return
     * 操作flag
     * 全部成功为 true
     * 至少存在一条失败则为 false
     * 这里需要业务逻辑层做回滚, 生成的代码没有做回滚操作
     */
    boolean batchUpdate(List<PaymentConfigDTO> targets);

    /**
     * 批量删除 Item
     * *注意* 逻辑删除, 非物理删除
     *
     * @param targets List Item 组 {@link PaymentConfigDTO}
     * @return 操作flag
     * 操作flag
     * 全部成功为 true
     * 至少存在一条失败则为 false
     * 这里需要业务逻辑层做回滚, 生成的代码没有做回滚操作
     */
    boolean batchRemove(List<PaymentConfigDTO> targets);
}