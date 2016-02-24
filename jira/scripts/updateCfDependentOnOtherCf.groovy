import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.fields.CustomField;
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder;
import com.atlassian.jira.ComponentManager;
import com.atlassian.jira.issue.customfields.option.Options;
import com.atlassian.jira.issue.customfields.option.Option;
import com.atlassian.jira.issue.ModifiedValue;
import com.atlassian.jira.component.ComponentAccessor;

CustomFieldManager customFieldManager = ComponentManager.getInstance().getCustomFieldManager();

String sourceCfValue = customFieldManager.getCustomFieldObject(10200).getValue(issue).toString();

CustomField targetCf = customFieldManager.getCustomFieldObject(10119);

int targetCfOption = (sourceCfValue == 'Reklamace') ? 10412 : 10107;

Options targetCfOptions = ComponentAccessor.getOptionsManager().getOptions(targetCf.getRelevantConfig(issue));

Option ChoosenOption = targetCfOptions.getOptionById(targetCfOption);

targetCf.updateValue(null, issue, new ModifiedValue(issue.getCustomFieldValue(targetCf), ChoosenOption), new DefaultIssueChangeHolder());